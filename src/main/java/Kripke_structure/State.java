package Kripke_structure;

import CTL_formula.Atomic;

import java.util.*;

public class State {
    private Integer index;
    private String nom;
    private Set<Atomic> labels;
    private boolean isInitial;
    private boolean checkCTL;
    private List<State> destinationStates = new ArrayList<State>();
    private List<State> sourceStates = new ArrayList<State>();


    public State() {
    }

    public State(Integer index, String nom, Set<Atomic> labels, boolean isInitial) {
        this.index = index;
        this.nom = nom;
        this.labels = labels;
        this.isInitial = isInitial;
        this.checkCTL = false;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
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

    public boolean isCheckCTL() {
        return checkCTL;
    }

    public void setCheckCTL(boolean checkCTL) {
        this.checkCTL = checkCTL;
    }

    public List<State> getDestinationStates() {
        return destinationStates;
    }

    public void setDestinationStates(List<State> destinationStates) {
        this.destinationStates = destinationStates;
    }

    public List<State> getSourceStates() {
        return sourceStates;
    }

    public void setSourceStates(List<State> sourceStates) {
        this.sourceStates = sourceStates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State state)) return false;
        return getIndex().equals(state.getIndex()) && getNom().equals(state.getNom()) && getLabels().equals(state.getLabels()) && Objects.equals(getDestinationStates(), state.getDestinationStates()) && Objects.equals(getSourceStates(), state.getSourceStates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex(), getNom(), getLabels(), getDestinationStates(), getSourceStates());
    }

    @Override
    public String toString() {
        return "State{" +
                "nom='" + nom + '\'' +
                ", labels=" + labels +
                '}'
                ;
    }
}
