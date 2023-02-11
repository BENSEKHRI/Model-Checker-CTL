package CTL_formula;

import Kripke_structure.KripkeStr;
import Kripke_structure.State;

import java.util.ArrayList;
import java.util.List;

public class AU extends TwoArg {
    public AU(CTL_Formula f1, CTL_Formula f2) {
        super(f1, f2);
    }

    @Override
    public String toString() {
        return "A (" + super.getF1() + " U " + super.getF2() + ")";
    }

    @Override
    public List<Boolean> marking(KripkeStr k) {
        List<Boolean> res = new ArrayList<>();

        List<Boolean> left = this.getF1().marking(k);
        List<Boolean> right = this.getF2().marking(k);

        List<Integer> degree = new ArrayList<>();

        for (State s : k.getStates()) {
            res.add(false);
            degree.add(s.getSuccessors().size());
        }

        List<State> LAU = new ArrayList<>();

        for (State s : k.getStates()) {
            if (right.get(s.getIndex())) {
                LAU.add(s);
            }
        }

        while (!LAU.isEmpty()) {
            State q = LAU.remove(0);

            res.set(q.getIndex(), true);

            for (State p : q.getPredecessors()) {

                degree.set(p.getIndex(), degree.get(p.getIndex()) - 1);

                if ((degree.get(p.getIndex()) == 0) && (left.get(p.getIndex())) && (!res.get(p.getIndex()))) {
                    LAU.add(p);
                }
            }
        }

        return res;
    }
}
