import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    // Method to validate phone numbers using a regular expression (regex)
    public static void validatePhoneNumber(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: ^(((\(\d{3}\))|(\+\d+\s\d{3})|\d{3})[-\.\s]?\d{3}[-\.\s]?\d{4})|\d{11,}$
        String phoneNumberRegex = "^(((\\(\\d{3}\\))|(\\+\\d+\\s\\d{3})|\\d{3})[-\\.\\s]?\\d{3}[-\\.\\s]?\\d{4})|\\d{11,}$";
        Pattern pattern = Pattern.compile(phoneNumberRegex);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("end")) {
            // Get a Matcher based on the target string
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                writer.write("valid phone number\n");
            } else {
                writer.write("invalid phone number\n");
            }
        }
        writer.write("x\n");
    }
}
