package CTL_formula;

import java.util.Objects;

public class Atomic extends CTL_Formula {
    private String label;

    public Atomic(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atomic atomic)) return false;
        return getLabel().equals(atomic.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel());
    }

    @Override
    public String toString() {
        return "Atomic{" +
                "label='" + label + '\'' +
                '}';
    }
}