import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Java program to solve common problems using regular expression (regex)
public class Main {
    public static void main(String[] args) {
        try {
            // Opening the input file for reading
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            // Opening the output file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.equals("end")) {
                    continue;
                }
                
                switch (line) {
                    case "1":
                        // Calling a method to validate email addresses using a regular expression (regex)
                        EmailAddressValidator.validateEmailAddress(line, reader, writer);
                        break;
                    case "2":
                        // Calling a method to validate phone numbers using a regular expression (regex)
                        PhoneNumberValidator.validatePhoneNumber(line, reader, writer);
                        break;
                    case "3":
                        // Calling a method to validate dates using a regular expression (regex)
                        DateValidator.validateDate(line, reader, writer);
                        break;
                    case "4":
                        // Calling a method to validate IP addresses using a regular expression (regex)
                        IPAddressValidator.validateIPAddress(line, reader, writer);
                        break;
                    case "5":
                        // Calling a method to validate C++ variables using a regular expression (regex)
                        VariableNameValidator.validateVariableName(line, reader, writer);
                        break;
                    case "6":
                         // Calling a method to validate that no string contains 3 consecutive b’s (lower or upper case) using regular expression (regex)
                        TripleBbValidator.validateTripleBb(line, reader, writer);
                        break;
                    case "7":
                        // Calling a method to extract strings with an odd number of a's and an odd number of b’s using regular expression (regex)
                        OddNumbersOfAsBsExtractor.extractOddNumbersOfAsBs(line, reader, writer);
                        break;
                    case "8":
                        // Calling a method to extract words whose length is a multiple of 3 using regular expression (regex)
                        MultipleOf3Extractor.extractMultipleOf3(line, reader, writer);
                        break;
                    case "9":
                        // Calling a method to extract URLs from a text file, given the path of the text file as input. Using regular expression (regex)
                        UrlExtractor.extractUrl(line, reader, writer);
                        break;   
                    case "10":
                        // Calling a method to validate mathematical expressions using a regular expression (regex)
                        MathematicalExpressionValidator.validateMathematicalExpression(line, reader, writer);
                        break;
                    default:
                        break;
                }
            }
            reader.close(); // Closing the input stream
            writer.close(); // Closing the output stream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}