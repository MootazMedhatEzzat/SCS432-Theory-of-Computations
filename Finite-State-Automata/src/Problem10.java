import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem10 {
    // Design an NFA that recognizes strings over the alphabet {0, 1} where every '0' is followed by at least one '1'
    public static void testNFA(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        // Define the finite set of states (Q)
        Set<String> states = new HashSet<>();
        states.add("q0");
        states.add("q1");

        // Define the finite set of symbols (alphabet / Σ)
        Set<Character> alphabet = new HashSet<>();
        alphabet.add('0');
        alphabet.add('1');

        // Define the transition table
        Map<String, Map<Character, Set<String>>> transitionTable = new HashMap<>();

        Map<Character, Set<String>> q0Transitions = new HashMap<>();
        q0Transitions.put('0', new HashSet<>(Set.of("q1")));
        q0Transitions.put('1', new HashSet<>(Set.of("q0")));
        transitionTable.put("q0", q0Transitions);

        Map<Character, Set<String>> q1Transitions = new HashMap<>();
        q1Transitions.put('1', new HashSet<>(Set.of("q0")));
        transitionTable.put("q1", q1Transitions);

        String initialState = "q0"; // Define the initial state

        // Define the final (accepting) state/states
        Set<String> finalStates = new HashSet<>();
        finalStates.add("q0");

        NFA nfa = new NFA(states, alphabet, transitionTable, initialState, finalStates);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("End")) {

            if (nfa.simulate(line)) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
        }
        writer.write("x\n\n");
    }
}