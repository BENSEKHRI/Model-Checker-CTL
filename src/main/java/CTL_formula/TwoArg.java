package CTL_formula;

import java.util.Objects;

public abstract class TwoArg extends CTL_Formula {
    private CTL_Formula f1, f2;

    public TwoArg(CTL_Formula f1, CTL_Formula f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public CTL_Formula getF1() {
        return f1;
    }

    public void setF1(CTL_Formula f1) {
        this.f1 = f1;
    }

    public CTL_Formula getF2() {
        return f2;
    }

    public void setF2(CTL_Formula f2) {
        this.f2 = f2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TwoArg twoArg)) return false;
        return getF1().equals(twoArg.getF1()) && getF2().equals(twoArg.getF2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getF1(), getF2());
    }
}
