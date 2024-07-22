import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    // Construct an DFA that accepts all strings {W | W is any string except 11 and 111}.
    public static void testDFA(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Define the finite set of states (Q)
        Set<String> states = new HashSet<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        states.add("q3");
        states.add("q4");

        // Define the finite set of symbols (alphabet / Σ)
        Set<Character> alphabet = new HashSet<>();
        alphabet.add('0');
        alphabet.add('1');

        // Define the transition table
        Map<String, Map<Character, String>> transitionTable = new HashMap<>();
        
        // Define the transition function (δ) for q0 state where δ: Q × Σ → Q
        Map<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('0', "q4"); // δ(q0, 0) = q4
        q0Transitions.put('1', "q1"); // δ(q0, 1) = q1
        transitionTable.put("q0", q0Transitions);

        // Define the transition function (δ) for q1 state where δ: Q × Σ → Q
        Map<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('0', "q4"); // δ(q1, 0) = q4
        q1Transitions.put('1', "q2"); // δ(q1, 1) = q2
        transitionTable.put("q1", q1Transitions);

        // Define the transition function (δ) for q2 state where δ: Q × Σ → Q
        Map<Character, String> q2Transitions = new HashMap<>();
        q2Transitions.put('0', "q4"); // δ(q2, 0) = q4
        q2Transitions.put('1', "q3"); // δ(q2, 1) = q3
        transitionTable.put("q2", q2Transitions);
        
        // Define the transition function (δ) for q3 state where δ: Q × Σ → Q
        Map<Character, String> q3Transitions = new HashMap<>();
        q3Transitions.put('0', "q4"); // δ(q3, 0) = q4
        q3Transitions.put('1', "q4"); // δ(q3, 1) = q4
        transitionTable.put("q3", q3Transitions);
        
        // Define the transition function (δ) for q4 state where δ: Q × Σ → Q
        Map<Character, String> q4Transitions = new HashMap<>();
        q4Transitions.put('0', "q4"); // δ(q4, 0) = q4
        q4Transitions.put('1', "q4"); // δ(q4, 1) = q4
        transitionTable.put("q4", q4Transitions);

        String initialState = "q0"; // Define the initial state

        // Define the final (accepting) state/states
        Set<String> finalStates = new HashSet<>();
        finalStates.add("q0");
        finalStates.add("q1");
        finalStates.add("q4");

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