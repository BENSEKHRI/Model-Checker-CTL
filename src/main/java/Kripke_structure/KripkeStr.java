package Kripke_structure;

import java.util.List;

public class KripkeStr {
    private List<State> states;
    private List<Transition> transitions;

    public KripkeStr(List<State> states, List<Transition> transitions) {
        this.states = states;
        this.transitions = transitions;
    }

    public List<State> getStates() {
        return states;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }
}
