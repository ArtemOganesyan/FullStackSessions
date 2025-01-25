package Session18;
import java.util.regex.Pattern;

public class RegExSamples {
    public static void main(String[] args) {
        String ssnPattern = "^(?!000|666|9..)\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$";

        String validSsn = "123-56-7890";
        String invalidSsn = "000-11-2345";

        System.out.println("SSN check result for valid value: " + Pattern.matches(ssnPattern, validSsn));
        System.out.println("SSN check result for invalid value: " + Pattern.matches(ssnPattern, invalidSsn));

        String emailPattern = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

        String validEmail = "fakeemail@gmail.com";
        String invalidEmail = "eee@co";

        System.out.println("Email check for valid: " + Pattern.matches(emailPattern, validEmail));
        System.out.println("Email check for invalid: " + Pattern.matches(emailPattern, invalidEmail));
    }
}
