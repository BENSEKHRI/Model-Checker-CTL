package CTL_formula;

import Kripke_structure.KripkeStr;

public class EX extends OneArg {
    public EX(CTL_Formula f) {
        super(f);
    }

    @Override
    public String toString() {
        return "(E X" + super.getF() + ")";
    }

    @Override
    public void marking (KripkeStr k, int index) {

    }
}
