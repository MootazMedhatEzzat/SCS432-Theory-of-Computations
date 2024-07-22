import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathematicalExpressionValidator {
    // Method to validate mathematical expressions using a regular expression (regex)
    public static void validateMathematicalExpression(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: ^((-?((\d+\.\d+)|\d+))|(-?((\d+\.\d+)|\d+)?[a-zA-Z]\*?))([+*\/-](((\d+\.\d+)|\d+)|(((\d+\.\d+)|\d+)?[a-zA-Z]\*?)))*=((-?(\d+\.\d+)|\d+)|(-?((\d+\.\d+)|\d+)?[a-zA-Z]\*?))([+*\/-](((\d+\.\d+)|\d+)|(((\d+\.\d+)|\d+)?[a-zA-Z]\*?)))*$
        String mathematicalExpressionRegex = "^((-?(\\d+\\.\\d+)|\\d+)|(-?((\\d+\\.\\d+)|\\d+)?[a-zA-Z]\\*?))([+*\\/-](((\\d+\\.\\d+)|\\d+)|(((\\d+\\.\\d+)|\\d+)?[a-zA-Z]\\*?)))*=((-?(\\d+\\.\\d+)|\\d+)|(-?((\\d+\\.\\d+)|\\d+)?[a-zA-Z]\\*?))([+*\\/-](((\\d+\\.\\d+)|\\d+)|(((\\d+\\.\\d+)|\\d+)?[a-zA-Z]\\*?)))*$";
        Pattern pattern = Pattern.compile(mathematicalExpressionRegex);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("end")) {
            // Get a Matcher based on the target string
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                writer.write("valid mathematical expression\n");
            } else {
                writer.write("invalid mathematical expression\n");
            }
        }
        writer.write("x");
    }
}
