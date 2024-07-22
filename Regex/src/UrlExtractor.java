import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlExtractor {
    // Method to extract URLs from a text file, given the path of the text file as input. Using regular expression (regex)
    public static void extractUrl(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Compile the regex: \b(https?|ftp)://\S+\b[^.\s]*
        String urlRegex = "\\b(https?|ftp)://\\S+\\b[^.\\s]*";
        Pattern pattern = Pattern.compile(urlRegex);

        String line;
        String fileLine;
        writer.write(problemNumber + "\n");

        int numberOfURLs = 0;
        int lineNumber = 1;

        while (!(line = reader.readLine()).equals("end")) {

            // Opening the input file specified by the current line (path of the text file)
            BufferedReader fileReader = new BufferedReader(new FileReader(line));
            StringBuilder urlsStringBuilder = new StringBuilder();

            writer.write("*" + line + "*" + "\n");

            while ((fileLine = fileReader.readLine()) != null) {
                // Get a Matcher based on the target string
                Matcher matcher = pattern.matcher(fileLine);

                while (matcher.find()) {
                    String matchedWord = matcher.group();
                    urlsStringBuilder.append("URL: ").append(matchedWord).append("\n");
                    urlsStringBuilder.append("Line: ").append(lineNumber).append("\n");
                    urlsStringBuilder.append("start index: ").append(matcher.start()).append(", end index: ").append(matcher.end()).append("\n");
                    lineNumber++;
                    numberOfURLs++;
                }
            }
            fileReader.close();
            writer.write("Number of URLs: " + numberOfURLs + "\n");
            writer.write(urlsStringBuilder.toString());
            numberOfURLs = 0;
            lineNumber = 1;
        }
        writer.write("x\n");
    }
}