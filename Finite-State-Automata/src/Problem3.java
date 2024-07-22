import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3 {
    // Design a DFA that accepts all strings that contain odd number of x's over {x, y}.
    public static void testDFA(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Define the finite set of states (Q)
        Set<String> states = new HashSet<>();
        states.add("q0");
        states.add("q1");

        // Define the finite set of symbols (alphabet / Σ)
        Set<Character> alphabet = new HashSet<>();
        alphabet.add('x');
        alphabet.add('y');

        // Define the transition table
        Map<String, Map<Character, String>> transitionTable = new HashMap<>();
        
        // Define the transition function (δ) for q0 state where δ: Q × Σ → Q
        Map<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('x', "q1"); // δ(q0, x) = q1
        q0Transitions.put('y', "q0"); // δ(q0, y) = q0
        transitionTable.put("q0", q0Transitions);

        // Define the transition function (δ) for q1 state where δ: Q × Σ → Q
        Map<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('x', "q0"); // δ(q1, x) = q0
        q1Transitions.put('y', "q1"); // δ(q1, y) = q1
        transitionTable.put("q1", q1Transitions);

        String initialState = "q0"; // Define the initial state

        // Define the final (accepting) state/states
        Set<String> finalStates = new HashSet<>();
        finalStates.add("q1");

        DFA dfa = new DFA(states, alphabet, transitionTable, initialState, finalStates);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("end")) {
            if (dfa.simulate(line)) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
        }
        writer.write("x\n\n");
    }
}