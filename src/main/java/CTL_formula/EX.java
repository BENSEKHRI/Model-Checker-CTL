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

        System.out.println("RES F");
        System.out.println(resF);


        for (State s : k.getStates()) {
            s.setCheckCTL(false);
        }

        for (State s : k.getStates()) {
            for (State q : s.getDestinationStates()) {
                if (q.isCheckCTL() && resF.get(q.getIndex())) {
                    s.setCheckCTL(true);
                    res.add(true);
                }
            }

            System.out.println(s + "--" + s.isCheckCTL());
        }

        System.out.println("Marquage");

        System.out.println(res);

        return res;
    }
}
