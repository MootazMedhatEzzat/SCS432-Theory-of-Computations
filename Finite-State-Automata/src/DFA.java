import java.util.Map;
import java.util.Set;

class DFA {
    // A DFA can be represented by a 5-tuple (Q, Σ, δ, q0, F) where
    private Set<String> states;      // Q is a finite set of states
    private Set<Character> alphabet; // Σ is a finite set of symbols called the alphabet
    private Map<String, Map<Character, String>> transitionTable; // δ is the transition function where δ: Q × Σ → Q
    private String initialState;     // q0 is the initial state from where any input is processed (q0 ∈ Q)
    private String currentState;
    private Set<String> finalStates; // F is a set of final state/states of Q (F ⊆ Q)

    public DFA(Set<String> states, Set<Character> alphabet, Map<String, Map<Character, String>> transitionTable,
               String initialState, Set<String> finalStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
        this.currentState = initialState;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    private void transition(char symbol) {
        if (!alphabet.contains(symbol)) {
            throw new IllegalArgumentException("Symbol not in alphabet");
        }
        currentState = transitionTable.get(currentState).get(symbol);
    }

    private void reset() {
        currentState = initialState; // Reset to the initial state
    }

    private boolean isAccepting() {
        // Checks if the current state is one of the final states
        return finalStates.contains(currentState);
    }

    public boolean simulate(String input) {
        reset(); // Reset the DFA to the initial state before simulating
        for (char symbol : input.toCharArray()) {
            transition(symbol);
        }
        return isAccepting();
    }
}
