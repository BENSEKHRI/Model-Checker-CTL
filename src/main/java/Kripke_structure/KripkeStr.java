package Kripke_structure;

import java.util.List;

public class KripkeStr {
    private List<State> states;
    private List<Arc> arcs;

    public KripkeStr(List<State> states, List<Arc> arcs) {
        this.states = states;
        this.arcs = arcs;
    }

    public void setSrcDestState() {
        for (Arc arc : arcs) {
            State src = arc.getSrc();
            State dest = arc.getDest();

            states.get(src.getIndex()).setSuccessors(dest);
            states.get(dest.getIndex()).setPredecessors(src);
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
