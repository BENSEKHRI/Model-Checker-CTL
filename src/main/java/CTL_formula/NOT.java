package CTL_formula;

import Kripke_structure.KripkeStr;
import Kripke_structure.State;

import java.util.ArrayList;
import java.util.List;

public class NOT extends OneArg {
    public NOT(CTL_Formula f) {
        super(f);
    }

    @Override
    public String toString() {
        return "~ (" + super.getF() + ")";
    }

    @Override
    public List<Boolean> marking(KripkeStr k) {
        List<Boolean> res = new ArrayList<>();

        List<Boolean> resF = this.getF().marking(k);

        for (State s : k.getStates()) {
            res.add(!resF.get(s.getIndex()));
        }

        return res;
    }
}
