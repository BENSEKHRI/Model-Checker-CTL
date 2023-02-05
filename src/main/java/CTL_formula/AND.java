package CTL_formula;

import Kripke_structure.KripkeStr;
import Kripke_structure.State;

public class AND extends TwoArg {
    public AND(CTL_Formula f1, CTL_Formula f2) {
        super(f1, f2);
    }

    @Override
    public String toString() {
        return "(" + super.getF1() + " /\\ " + super.getF2() + ")";
    }

    @Override
    public void marking(KripkeStr k, int index) {
        super.getF1().marking(k, 0);
        super.getF2().marking(k, 1);
        for (State s : k.getStates()) {
            s.setCheckCTLIndex(s.getCheckCTLIndex(0) && s.getCheckCTLIndex(1), index);
        }
    }
}
