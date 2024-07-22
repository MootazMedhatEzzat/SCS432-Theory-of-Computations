import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    // Construct an NFA that accepts all strings over the alphabet {0, 1} containing an equal number of occurrences of '01' and '10'.
    public static void testNFA(String problemNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
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
        Map<String, Map<Character, Set<String>>> transitionTable = new HashMap<>();

        Map<Character, Set<String>> q0Transitions = new HashMap<>();
        q0Transitions.put(null, new HashSet<>(Set.of("q1", "q2"))); // Transition without from q0 to q1 and q2 without consuming any input symbol
        transitionTable.put("q0", q0Transitions);

        Map<Character, Set<String>> q1Transitions = new HashMap<>();
        q1Transitions.put('0', new HashSet<>(Set.of("q1")));
        q1Transitions.put('1', new HashSet<>(Set.of("q3")));
        transitionTable.put("q1", q1Transitions);

        Map<Character, Set<String>> q2Transitions = new HashMap<>();
        q2Transitions.put('0', new HashSet<>(Set.of("q4")));
        q2Transitions.put('1', new HashSet<>(Set.of("q2")));
        transitionTable.put("q2", q2Transitions);

        Map<Character, Set<String>> q3Transitions = new HashMap<>();
        q3Transitions.put('0', new HashSet<>(Set.of("q1")));
        q3Transitions.put('1', new HashSet<>(Set.of("q3")));
        transitionTable.put("q3", q3Transitions);

        Map<Character, Set<String>> q4Transitions = new HashMap<>();
        q4Transitions.put('0', new HashSet<>(Set.of("q4")));
        q4Transitions.put('1', new HashSet<>(Set.of("q2"))); 
        transitionTable.put("q4", q4Transitions);

        String initialState = "q0"; // Define the initial state

        // Define the final (accepting) state/states
        Set<String> finalStates = new HashSet<>();
        finalStates.add("q1");
        finalStates.add("q2");

        NFA nfa = new NFA(states, alphabet, transitionTable, initialState, finalStates);

        String line;
        writer.write(problemNumber+"\n");

        while (!(line = reader.readLine()).equals("end")) {
            if (nfa.simulate(line)) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
        }
        writer.write("x\n\n");
    }
}