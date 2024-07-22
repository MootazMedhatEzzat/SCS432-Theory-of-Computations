import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidator {
    // Method to validate IP addresses using a regular expression (regex)
    public static void validateIPAddress(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: ^([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])(\.([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])){3}$
        /*
           ([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5]): Matches numbers between 0 and 255
                                                   [01]?[0-9][0-9]? : matches numbers from 0 to 199
                                                   2[0-4][0-9]      : matches numbers from 200 to 249.
                                                   25[0-5]          : matches numbers from 250 to 255.
         */
        String ipAddressRegex = "^([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])(\\.([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])){3}$";
        Pattern pattern = Pattern.compile(ipAddressRegex);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("end")) {
            // Get a Matcher based on the target string
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                writer.write("valid IP address\n");
            } else {
                writer.write("invalid IP address\n");
            }
        }
        writer.write("x\n");
    }
}
