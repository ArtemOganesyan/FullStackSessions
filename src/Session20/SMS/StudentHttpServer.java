package Session20.SMS;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class StudentHttpServer {
    private static final int PORT = 8080;
    private StudentService studentService;
    private ObjectMapper objectMapper = new ObjectMapper();

    public StudentHttpServer(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) throws IOException {
        StudentRepository studentRepository = new FileStudentRepository("students.csv");
        StudentService studentService = new StudentService(studentRepository);
        StudentHttpServer server = new StudentHttpServer(studentService);
        server.start();
    }

    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/students", new StudentHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("HTTP server started on port " + PORT);
    }

    private class StudentHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            String response = "";

            switch (method) {
                case "GET":
                    response = handleGet(exchange);
                    break;
                case "POST":
                    response = handlePost(exchange);
                    break;
                case "PUT":
                    response = handlePut(exchange);
                    break;
                case "DELETE":
                    response = handleDelete(exchange);
                    break;
                default:
                    exchange.sendResponseHeaders(405, -1); // Method Not Allowed
                    return;
            }

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        private String handleGet(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            if (query == null) {
                List<Student> students = studentService.getStudents();
                return objectMapper.writeValueAsString(students);
            } else {
                int id = Integer.parseInt(query.split("=")[1]);
                Student student = studentService.getStudents().stream()
                        .filter(s -> s.getId() == id)
                        .findFirst()
                        .orElse(null);
                return student != null ? objectMapper.writeValueAsString(student) : "{\"error\": \"Student not found\"}";
            }
        }

        private String handlePost(HttpExchange exchange) throws IOException {
            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            JsonNode jsonNode = objectMapper.readTree(requestBody);

            int id = jsonNode.get("id").asInt();
            String firstName = jsonNode.get("firstName").asText();
            String lastName = jsonNode.get("lastName").asText();
            int age = jsonNode.get("age").asInt();
            Major major = Major.valueOf(jsonNode.get("major").asText());

            Student student = new UndergradStudent(id, firstName, lastName, age, major);
            studentService.addStudent(student);
            studentService.saveStudents();
            return objectMapper.writeValueAsString(student);
        }

        private String handlePut(HttpExchange exchange) throws IOException {
            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            JsonNode jsonNode = objectMapper.readTree(requestBody);

            int id = jsonNode.get("id").asInt();
            String firstName = jsonNode.get("firstName").asText();
            String lastName = jsonNode.get("lastName").asText();
            int age = jsonNode.get("age").asInt();
            Major major = Major.valueOf(jsonNode.get("major").asText());

            Student student = studentService.getStudents().stream()
                    .filter(s -> s.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (student != null) {
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setMajor(major);
                studentService.saveStudents();
                return objectMapper.writeValueAsString(student);
            } else {
                return "{\"error\": \"Student not found\"}";
            }
        }

        private String handleDelete(HttpExchange exchange) {
            String query = exchange.getRequestURI().getQuery();
            int id = Integer.parseInt(query.split("=")[1]);
            studentService.deleteStudent(id);
            studentService.saveStudents();
            return "{\"message\": \"Deleted student with ID: " + id + "\"}";
        }
    }
}