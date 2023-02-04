package CTL_formula;

import Kripke_structure.KripkeStr;
import Kripke_structure.State;

public class NOT extends OneArg {
    public NOT(CTL_Formula f) {
        super(f);
    }

    @Override
    public String toString() {
        return "(~ " + super.getF() + ")";
    }

    @Override
    public void marking(KripkeStr k) {
        this.getF().marking(k);
        for (State s : k.getStates()) {
            s.setCheckCTL(!s.isCheckCTL());
        }
    }
}
