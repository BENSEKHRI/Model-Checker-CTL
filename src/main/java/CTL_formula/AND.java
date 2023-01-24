package CTL_formula;

public class AND extends TwoArg {
    public AND(CTL_Formula f1, CTL_Formula f2) {
        super(f1, f2);
    }

    @Override
    public String toString() {
        return "AND{}";
    }
}
