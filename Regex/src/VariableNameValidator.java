import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableNameValidator {
    // Method to validate C++ variables using a regular expression (regex)
    public static void validateVariableName(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: ^[a-zA-Z_]\w*$
        /*
           [a-zA-Z_]: Matches the first character, alphabetic (uppercase or lowercase) or underscore.
           \w*      : Matches zero or more alphanumeric characters and underscores.
         */
        String variableNameRegex = "^([a-zA-Z_]\\w*)$";
        Pattern pattern = Pattern.compile(variableNameRegex);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("end")) {
            // Get a Matcher based on the target string
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                writer.write("valid C++ variable name\n");
            } else {
                writer.write("invalid C++ variable name\n");
            }
        }
        writer.write("x\n");
    }
}
