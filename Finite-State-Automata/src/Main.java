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
                        Problem1.testDFA(line, reader, writer);
                        break;
                    case "2":
                        Problem2.testDFA(line, reader, writer);
                        break;
                    case "3":
                        Problem3.testDFA(line, reader, writer);
                        break;
                    case "4":
                        Problem4.testDFA(line, reader, writer);
                        break;
                    case "5":
                        Problem5.testDFA(line, reader, writer);
                        break;
                    case "6":
                        Problem6.testDFA(line, reader, writer);
                        break;
                    case "7":
                        Problem7.testNFA(line, reader, writer);
                        break;
                    case "8":
                        Problem8.testNFA(line, reader, writer);
                        break;
                    case "9":
                        Problem9.testNFA(line, reader, writer);
                        break;
                    case "10":
                        Problem10.testNFA(line, reader, writer);
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