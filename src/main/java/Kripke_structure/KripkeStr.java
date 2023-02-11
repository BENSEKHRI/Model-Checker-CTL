package Kripke_structure;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Kripke structure.
 * A Kripke structure is composed of a list of states and a list of arcs.
 */
public class KripkeStr {
    private String name;
    private List<State> states;
    private List<Arc> arcs;

    public KripkeStr() {
        this.name = "nameless";
        this.states = new ArrayList<>();
        this.arcs = new ArrayList<>();
    }

    public KripkeStr(List<State> states, List<Arc> arcs) {
        this.name = "nameless";
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

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public List<State> getStates() {
        return states;
    }

    public List<Arc> getTransitions() {
        return arcs;
    }

    /**
     * This function allows you to transform a Kripke structure into a PNG image
     *
     * @throws IOException
     */
    public void writePng() throws IOException {
        StringBuilder dotSource = new StringBuilder("digraph {\n");

        for (State src : states) {
            if (src.isInitial()) {
                dotSource.append(src.getName()).append("[label =\"").append(src.getName()).append(":").append(src.getLabels()).append("\", style=\"filled\"]\n");
            } else {
                dotSource.append(src.getName()).append("[label =\"").append(src.getName()).append(":").append(src.getLabels()).append("\"]\n");
            }
        }

        for (State src : states) {
            for (State succ : src.getSuccessors()) {
                dotSource.append(src.getName()).append(" -> ").append(succ.getName()).append("\n");
            }
        }

        dotSource.append("}\n");

        MutableGraph g = new Parser().read(dotSource.toString());
        Graphviz.fromGraph(g).render(Format.PNG).toFile(new File("src/main/resources/images/" + name + ".png"));

        System.out.println("\n+-------------------------------------------+");
        System.out.println("| Une image png de la SK à été créee dans : |");
        System.out.println("| \033[33m[src/main/resources/images/" + name + ".png]\033[0m");
        System.out.println("+-------------------------------------------+\n");
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Structure de Kripke :\n{\n\tÉtats = [");

        for (State state : states) {
            res.append(state.printState());
        }

        res.append("]\n\n\tArcs = ").append(arcs).append("\n}");

        return res.toString();
    }
}
