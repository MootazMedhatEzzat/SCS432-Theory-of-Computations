import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TripleBbValidator {
    // Method to validate that no string contains 3 consecutive b’s (lower or upper case) using regular expression (regex)
    public static void validateTripleBb(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: ^(?!(\w*[bB]{3}))\w+$
        String tripleBbRegex = "^(?!(\\w*[bB]{3}))\\w+$";
        Pattern pattern = Pattern.compile(tripleBbRegex);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("end")) {
            // Get a Matcher based on the target string
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                writer.write("valid string\n");
            } else {
                writer.write("invalid string, has 3 consecutive b’s\n");
            }
        }
        writer.write("x\n");
    }
}
