package Kripke_structure;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

    public void writeDot() {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/KS.dot")))) {
            out.write("digraph {");
            out.newLine();
            for (State src : states) {
                out.write(src.getNom() + "[label =\"" + src.getNom() + ":" + src.getLabels() + "\"]");
                out.newLine();
            }

            for (State src : states) {
                for (State succ : src.getSuccessors()) {
                    out.write(src.getNom() + " -> " + succ.getNom());
                    out.newLine();
                }
            }

            out.write("}");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "KripkeStr{" +
                "states=" + states +
                ", arcs=" + arcs +
                '}';
    }
}
