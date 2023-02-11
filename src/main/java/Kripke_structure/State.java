package Kripke_structure;

import CTL_formula.Atomic;

import java.util.*;

/**
 * Class representing a State in a Kripke structure.
 * Each state has a unique identifier, a set of atomic propositions, and a flag indicating whether it is the initial state.
 */
public class State {
    private static int indexNext = 0;
    private int index;
    private String name;
    private Set<Atomic> labels;
    private boolean isInitial;
    private List<State> successors = new ArrayList<>();
    private List<State> predecessors = new ArrayList<>();

    public State(String name, Set<Atomic> labels, boolean isInitial) {
        this.index = indexNext++;
        this.name = name;
        this.labels = labels;
        this.isInitial = isInitial;
    }

    public static void resetIndex() {
        indexNext = 0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Atomic> getLabels() {
        return labels;
    }

    public void setLabels(Set<Atomic> labels) {
        this.labels = labels;
    }

    public boolean isInitial() {
        return isInitial;
    }

    public void setInitial(boolean initial) {
        isInitial = initial;
    }

    public List<State> getSuccessors() {
        return successors;
    }

    public void setSuccessors(State dest) {
        this.successors.add(dest);
    }

    public List<State> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(State src) {
        this.predecessors.add(src);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State state)) return false;
        return getIndex() == state.getIndex() && isInitial() == state.isInitial() && getName().equals(state.getName()) && getLabels().equals(state.getLabels()) && getSuccessors().equals(state.getSuccessors()) && getPredecessors().equals(state.getPredecessors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex(), getName(), getLabels(), isInitial(), getSuccessors(), getPredecessors());
    }

    @Override
    public String toString() {
        return name;
    }

    public String printState() {
        if (isInitial) {
            return "\033[35m{ " + index +
                    ", |" + name + '|' +
                    ", " + labels +
                    ", \033[33m[Initial]\033[0m }, \033[0m";
        } else {
            return "\033[35m{ " + index +
                    ", |" + name + '|' +
                    ", " + labels + " }, \033[0m";
        }
    }
}
