import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1 {
    // Design a DFA that accepts all strings which do not contain the substring ba over {a, b}.
    public static void testDFA(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Define the finite set of states (Q)
        Set<String> states = new HashSet<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");

        // Define the finite set of symbols (alphabet / Σ)
        Set<Character> alphabet = new HashSet<>();
        alphabet.add('a');
        alphabet.add('b');

        // Define the transition table
        Map<String, Map<Character, String>> transitionTable = new HashMap<>();
        
        // Define the transition function (δ) for q0 state where δ: Q × Σ → Q
        Map<Character, String> q0Transitions = new HashMap<>();
        q0Transitions.put('a', "q0"); // δ(q0, a) = q0
        q0Transitions.put('b', "q1"); // δ(q0, b) = q1
        transitionTable.put("q0", q0Transitions);

        // Define the transition function (δ) for q1 state where δ: Q × Σ → Q
        Map<Character, String> q1Transitions = new HashMap<>();
        q1Transitions.put('a', "q2"); // δ(q1, a) = q2
        q1Transitions.put('b', "q1"); // δ(q1, b) = q1
        transitionTable.put("q1", q1Transitions);

        // Define the transition function (δ) for q2 state where δ: Q × Σ → Q
        Map<Character, String> q2Transitions = new HashMap<>();
        q2Transitions.put('a', "q2"); // δ(q2, a) = q2
        q2Transitions.put('b', "q2"); // δ(q2, b) = q2
        transitionTable.put("q2", q2Transitions);

        String initialState = "q0"; // Define the initial state

        // Define the final (accepting) state/states
        Set<String> finalStates = new HashSet<>();
        finalStates.add("q0");
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
