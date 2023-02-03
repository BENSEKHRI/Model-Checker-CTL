package CTL_formula;

public class OR extends TwoArg {
    public OR(CTL_Formula f1, CTL_Formula f2) {
        super(f1, f2);
    }

    @Override
    public String toString() {
        return "OR{}";
    }
}
