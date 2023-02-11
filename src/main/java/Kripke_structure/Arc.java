package Kripke_structure;

import java.util.Objects;

/**
 * Class representing an Arc in a Kripke structure.
 * Each arc has a source state and a destination state.
 */
public class Arc {
    private int src;
    private int dest;

    public Arc(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arc arc)) return false;
        return getSrc() == arc.getSrc() && getDest() == arc.getDest();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSrc(), getDest());
    }

    @Override
    public String toString() {
        return "|" + src + " -> " + dest + "|";
    }
}
