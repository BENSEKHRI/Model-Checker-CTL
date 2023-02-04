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
    public void marking(KripkeStr k) {
        super.getF1().marking(k);
        KripkeStr  tmp = k;
        super.getF2().marking(k);
        for (State s : k.getStates()) {
            for (State sTmp : tmp.getStates()) {
                if (s.getIndex() == sTmp.getIndex()) {
                    s.setCheckCTL(s.isCheckCTL() && sTmp.isCheckCTL());
                }
            }
        }
    }
}
