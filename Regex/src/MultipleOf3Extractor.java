import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultipleOf3Extractor {
    // Method to extract words whose length is a multiple of 3 using regular expression (regex)
    public static void extractMultipleOf3(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: \b(\w{3})\b
        String multipleOf3Regex = "\\b(\\w{3})\\b";
        Pattern pattern = Pattern.compile(multipleOf3Regex);

        String line;
        writer.write(problemNumber+"\n");

        int totalMatchedWords = 0;

        while (!(line = reader.readLine()).equals("end")) {
            // Get a Matcher based on the target string
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                totalMatchedWords++;
            }

            writer.write("*" + line + "*" + "\n");

            if (totalMatchedWords > 0) {
                writer.write("number of matched words: " + totalMatchedWords + "\n");

                totalMatchedWords = 0;
                matcher.reset();

                while (matcher.find()) {
                    String matchedWord = matcher.group();
                    writer.write("matched word: " + matchedWord + "\n");
                    writer.write("start index: " + matcher.start() + ", end index: " + matcher.end() + "\n");
                }
            }
            else {
                writer.write("No word matches" +"\n");
            }
        }
        writer.write("x\n");
    }
}
