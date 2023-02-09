package Kripke_structure;

import CTL_formula.Atomic;

import java.util.*;

public class State {
    private static int indexNext = 0;
    private int index;
    private String nom;
    private Set<Atomic> labels;
    private boolean isInitial;
    private List<State> successors = new ArrayList<State>();
    private List<State> predecessors = new ArrayList<State>();


    public State() {
    }

    public State(String nom, Set<Atomic> labels, boolean isInitial) {
        this.index = indexNext++;
        this.nom = nom;
        this.labels = labels;
        this.isInitial = isInitial;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        return getIndex() == state.getIndex() && isInitial() == state.isInitial() && getNom().equals(state.getNom()) && getLabels().equals(state.getLabels()) && getSuccessors().equals(state.getSuccessors()) && getPredecessors().equals(state.getPredecessors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex(), getNom(), getLabels(), isInitial(), getSuccessors(), getPredecessors());
    }

    @Override
    public String toString() {
        return nom;
    }
}
