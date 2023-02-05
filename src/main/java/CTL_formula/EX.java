package CTL_formula;

import Kripke_structure.KripkeStr;
import Kripke_structure.State;

import java.util.ArrayList;
import java.util.List;

public class EX extends OneArg {
    public EX(CTL_Formula f) {
        super(f);
    }

    @Override
    public String toString() {
        return "(E X " + super.getF() + ")";
    }

    @Override
    public List<Boolean> marking(KripkeStr k) {
        List<Boolean> res = new ArrayList<>();

        List<Boolean> resF = this.getF().marking(k);

        for (State s : k.getStates()) {
            res.add(false);
        }

        for (State s : k.getStates()) {
            for (State q : s.getSuccessors()) {
                if (resF.get(q.getIndex())) {
                    res.set(s.getIndex(), true);
                }
            }
        }

        return res;
    }
}
