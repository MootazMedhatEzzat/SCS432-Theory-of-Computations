import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OddNumbersOfAsBsExtractor {
    // Method to extract strings with an odd number of a's and an odd number of b’s using regular expression (regex)
    public static void extractOddNumbersOfAsBs(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: (a(aa)*b(bb)*(aa)*)|((aa)*b(bb)*a(aa)*)
        String multipleOf3Regex = "(a(aa)*b(bb)*(aa)*)|((aa)*b(bb)*a(aa)*)";
        Pattern pattern = Pattern.compile(multipleOf3Regex);

        String line;
        writer.write(problemNumber+"\n");

        int totalMatchedStrings = 0;

        while (!(line = reader.readLine()).equals("end")) {
            // Get a Matcher based on the target string
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                totalMatchedStrings++;
            }
            writer.write("*" + line + "*" + "\n");

            if (totalMatchedStrings > 0) {
                writer.write("number of matched substrings: " + totalMatchedStrings + "\n");

                totalMatchedStrings = 0;
                matcher.reset();

                while (matcher.find()) {
                    String matchedSubstring = matcher.group();
                    writer.write("matched substring: " + matchedSubstring + "\n");
                    writer.write("start index: " + matcher.start() + ", end index: " + matcher.end() + "\n");
                }
            }
            else {
                writer.write("No substring matches" +"\n");
            }
        }
        writer.write("x\n");
    }
}