import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {
    // Method to validate dates using a regular expression (regex)
    public static void validateDate(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: ^(((?!0000)\d{4})(/|-)(0[1-9]|1[0-2])(/|-)(0[1-9]|[12]\d)|3[01])|((0?[1-9]|[12]\d|3[01])(/|-)(0?[1-9]|1[0-2])(/|-)(?!0000)\d{4})$
        /*
           (0[1-9]|1[0-2])       : Matches months from 01 to 12
                                   0[1-9] : matches months from 01 to 09.
                                   1[0-2] : matches months from 10 to 12.
           (0[1-9]|[12]\d|3[01]) : Matches days from 01 to 31
                                   0[1-9] : matches days from 01 to 09.
                                   [12]\d : matches days from 10 to 29.
                                   3[01]  : matches days from 30 to 31.
         */
        String dateRegex = "^(((?!0000)\\d{4})(/|-)(0[1-9]|1[0-2])(/|-)(0[1-9]|[12]\\d)|3[01])|((0?[1-9]|[12]\\d|3[01])(/|-)(0?[1-9]|1[0-2])(/|-)((?!0000)\\d{4}))$";
        Pattern pattern = Pattern.compile(dateRegex);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("end")) {
            // Get a Matcher based on the target string
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                writer.write("valid date\n");
            } else {
                writer.write("invalid date\n");
            }
        }
        writer.write("x\n");
    }
}
