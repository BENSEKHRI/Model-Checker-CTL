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
    public void marking(KripkeStr k, int index) {
        this.getF().marking(k, index);
        for (State s : k.getStates()) {
            s.setCheckCTLIndex(!s.getCheckCTLIndex(index), index);
        }
    }
}
