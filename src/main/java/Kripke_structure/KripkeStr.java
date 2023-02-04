package Kripke_structure;

import java.util.List;

public class KripkeStr {
    private List<State> states;
    private List<Arc> arcs;

    public KripkeStr(List<State> states, List<Arc> arcs) {
        this.states = states;
        this.arcs = arcs;
    }

    public List<State> getStates() {
        return states;
    }

    public List<Arc> getTransitions() {
        return arcs;
    }
}
