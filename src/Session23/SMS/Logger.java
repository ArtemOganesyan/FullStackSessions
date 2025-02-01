package Session23.SMS;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String LOG_FILE = "student_server.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static void log(String message) throws IOException {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
            PrintWriter pw = new PrintWriter(fw)) {
                String timeStamp = LocalDateTime.now().format(formatter);
                pw.println(timeStamp + " - " + message);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
