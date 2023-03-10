package CTL_formula;

import Kripke_structure.KripkeStr;
import Kripke_structure.State;

import java.util.ArrayList;
import java.util.List;

public class AND extends TwoArg {
    public AND(CTL_Formula f1, CTL_Formula f2) {
        super(f1, f2);
    }

    @Override
    public String toString() {
        return "(" + super.getF1() + " /\\ " + super.getF2() + ")";
    }

    @Override
    public List<Boolean> marking(KripkeStr k) {
        List<Boolean> res = new ArrayList<>();

        List<Boolean> left = this.getF1().marking(k);
        List<Boolean> right = this.getF2().marking(k);

        for (State s : k.getStates()) {
            res.add(left.get(s.getIndex()) && right.get(s.getIndex()));
        }

        return res;
    }
}
