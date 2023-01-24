package CTL_formula;

import java.util.Objects;

public abstract class OneArg extends CTL_Formula {
    private CTL_Formula f;

    public OneArg(CTL_Formula f) {
        this.f = f;
    }

    public CTL_Formula getF() {
        return f;
    }

    public void setF(CTL_Formula f) {
        this.f = f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneArg oneArg)) return false;
        return getF().equals(oneArg.getF());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getF());
    }
}
