package CTL_formula;

import Kripke_structure.KripkeStr;

import java.util.List;

public class EU extends TwoArg {
    public EU(CTL_Formula f1, CTL_Formula f2) {
        super(f1, f2);
    }

    @Override
    public String toString() {
        return "(E " + super.getF1() + " U " + super.getF2();
    }

    @Override
    public List<Boolean> marking (KripkeStr k) {
        return null;
    }
}
