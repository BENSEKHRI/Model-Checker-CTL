package Kripke_structure;

import java.util.Objects;

public class Arc {
    private State src;
    private State dest;

    public Arc(State src, State dest) {
        this.src = src;
        this.dest = dest;
    }

    public State getSrc() {
        return src;
    }

    public void setSrc(State src) {
        this.src = src;
    }

    public State getDest() {
        return dest;
    }

    public void setDest(State dest) {
        this.dest = dest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arc that)) return false;
        return getSrc().equals(that.getSrc()) && getDest().equals(that.getDest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSrc(), getDest());
    }

    @Override
    public String toString() {
        return src.getNom() + " --> " + dest.getNom();
    }
}
