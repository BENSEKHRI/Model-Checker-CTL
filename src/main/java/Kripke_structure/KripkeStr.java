package Kripke_structure;

import java.util.ArrayList;
import java.util.List;

public class KripkeStr {
    private List<State> states;
    private List<Arc> arcs;

    public KripkeStr() {
        this.states = new ArrayList<>();
        this.arcs = new ArrayList<>();
    }

    public KripkeStr(List<State> states, List<Arc> arcs) {
        this.states = states;
        this.arcs = arcs;
    }

    public void setSrcDestState() {
        for (Arc arc : arcs) {
            int src = arc.getSrc();
            int dest = arc.getDest();

            states.get(src).setSuccessors(states.get(dest));
            states.get(dest).setPredecessors(states.get(src));
        }
    }

    public List<State> getStates() {
        return states;
    }

    public List<Arc> getTransitions() {
        return arcs;
    }

    @Override
    public String toString() {
        return "KripkeStr{" +
                "states=" + states +
                ", arcs=" + arcs +
                '}';
    }
}
