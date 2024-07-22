import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.Map;
import java.util.Set;

class NFA {
    // An NFA can be represented by a 5-tuple (Q, Σ, δ, q0, F) where
    private Set<String> states;      // Q is a finite set of states
    private Set<Character> alphabet; // Σ is a finite set of symbols called the alphabets
    private Map<String, Map<Character, Set<String>>> transitionTable; // δ is the transition function where δ: Q × Σ → 2Q
                                                                      // (Here the power set of Q (2Q) has been taken because in case of NDFA, from a state, 
                                                                      // transition can occur to any combination of Q states)

    private String initialState;     // q0 is the initial state from where any input is processed (q0 ∈ Q)
    private Set<String> finalStates; // F is a set of final state/states of Q (F ⊆ Q)

    public NFA(Set<String> states, Set<Character> alphabet, Map<String, Map<Character, Set<String>>> transitionTable,
               String initialState, Set<String> finalStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    /**
     * Computes the epsilon closure of a given state.
     * Epsilon closure of a state is the set of states reachable from the given state using only epsilon transitions (transitions without consuming any input symbol).
     **/
    private Set<String> epsilonClosure(String state) {
        Set<String> closure = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(state);

        while (!stack.isEmpty()) {
            String currentState = stack.pop();
            closure.add(currentState);
            // Check if epsilon transition is possible from the current state
            if (transitionTable.containsKey(currentState) && transitionTable.get(currentState).containsKey(null)) {
                // Add all states reachable via epsilon transition
                for (String nextState : transitionTable.get(currentState).get(null)) {
                    if (!closure.contains(nextState)) {
                        stack.push(nextState);
                    }
                }
            }
        }

        return closure;
    }

   
    // Computes the set of states reachable from a given set of states by consuming a specified input symbol. 
    private Set<String> move(Set<String> states, char symbol) {
        Set<String> nextStates = new HashSet<>();
        for (String state : states) {
            // Check if transition is defined for the current state and input symbol
            if (transitionTable.containsKey(state) && transitionTable.get(state).containsKey(symbol)) {
                // Add all states reachable via transition with the input symbol
                nextStates.addAll(transitionTable.get(state).get(symbol));
            }
        }
        return nextStates;
    }

    /**
     * Computes the epsilon closure of a set of states.
     * Epsilon closure of a set of states is the union of epsilon closures of individual states.
     **/
    private Set<String> epsilonMove(Set<String> states) {
        Set<String> epsilonStates = new HashSet<>();
        for (String state : states) {
            // Union of epsilon closures of individual states
            epsilonStates.addAll(epsilonClosure(state));
        }
        return epsilonStates;
    }

    // Checks if any state in the given set of states is a final state.
    private boolean isAccepting(Set<String> states) {
        for (String state : states) {
            if (finalStates.contains(state)) {
                return true;
            }
        }
        return false;
    }
    
    // Simulates the NFA on a given input string.
    public boolean simulate(String input) {
        Set<String> currentStates = epsilonClosure(initialState);
        for (char symbol : input.toCharArray()) {
            // Move to the next state considering the current input symbol
            currentStates = epsilonMove(move(currentStates, symbol));
        }
        // Check if any of the resulting states is a final state
        return isAccepting(currentStates);
    }
}