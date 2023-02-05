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
            res.add(false);
        }

        for (State s : k.getStates()) {
            System.out.println(s.isCheckCTL());
        }

        for (State s : k.getStates()) {
            System.out.println(s.getSuccessors() + "\n\n");
            for (State q : s.getSuccessors()) {
                if (q.isCheckCTL() && resF.get(q.getIndex())) {
                    s.setCheckCTL(true);
                    res.set(s.getIndex(), true);
                } else {
                    s.setCheckCTL(false);
                }
            }

            System.out.println(s + " - " + s.isCheckCTL());
        }

        int i = 0;
        for (State s : k.getStates()) {

        }



        for (State s : k.getStates()) {
            System.out.println(s.isCheckCTL());
        }

        System.out.println(res);


        return res;
    }
}
