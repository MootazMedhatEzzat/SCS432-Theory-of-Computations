import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddressValidator {
    // Method to validate email addresses using a regular expression (regex)
    public static void validateEmailAddress(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: ^[\w+%\.-]+@[a-zA-Z0-9\.-]+\.[a-zA-Z]{2,}$
        /* Email Validation According to RFC 5322 (localPart@domainPart.topLevelDomain)
                                                   m.mewahab@fci-cu.edu.eg
           ^              : Asserts the start of the string, ensuring that the email starts exactly when the pattern begins.
           localPart      : For example "m.wahab"
                            [\w+%\.-]+     : Matches one or more alphanumeric characters, underscores, hyphens, plus signs, percentage signs and dots.
           '@' Symbol     : Only one occurrence of the "@" symbol.
           domainPart     : For example "fci-cu.edu"
                            [a-zA-Z0-9\.-]+: Matches one or more alphanumeric characters, hyphens, and dots.
           '.' dot        : Only one occurrence of a dot.
           topLevelDomain : For example "eg"
                            [a-zA-Z]{2,}   : Matches two or more alphabetic characters.
           $              : Asserts the end of the string, ensuring that the email ends exactly when the pattern ends.
        */
        String emailAddressRegex = "^[\\w+%\\.-]+@[a-zA-Z0-9\\.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailAddressRegex);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("end")) {
            // Get a Matcher based on the target string
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                writer.write("valid email\n");
            } else {
                writer.write("invalid email\n");
            }
        }
        writer.write("x\n");
    }
}
