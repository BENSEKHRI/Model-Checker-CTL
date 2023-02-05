package CTL_formula;

import Kripke_structure.KripkeStr;

public class AU extends TwoArg {
    public AU(CTL_Formula f1, CTL_Formula f2) {
        super(f1, f2);
    }

    @Override
    public String toString() {
        return "(A " + super.getF1() + " U " + super.getF2();
    }

    @Override
    public void marking (KripkeStr k, int index) {

    }
}
