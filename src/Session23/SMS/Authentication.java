package Session23.SMS;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Authentication {
    public static boolean authenticate(HttpExchange exchange) throws IOException {
        String apiKey = exchange.getRequestHeaders().getFirst("X-Api-Key");
        if (apiKey != null) {
            if (apiKey.equals("mySecretKey")) {
                return  true;
            }
        } else {
            String response = "{\"error\":\"Unauthorized\"}";
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(401, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
            return false;
        }
        return false;
    }
}
