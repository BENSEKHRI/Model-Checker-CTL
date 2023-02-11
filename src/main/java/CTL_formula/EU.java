package CTL_formula;

import Kripke_structure.KripkeStr;
import Kripke_structure.State;

import java.util.ArrayList;
import java.util.List;

public class EU extends TwoArg {
    public EU(CTL_Formula f1, CTL_Formula f2) {
        super(f1, f2);
    }

    @Override
    public String toString() {
        return "E (" + super.getF1() + " U " + super.getF2() + ")";
    }

    @Override
    public List<Boolean> marking(KripkeStr k) {
        List<Boolean> res = new ArrayList<>();

        List<Boolean> left = this.getF1().marking(k);
        List<Boolean> right = this.getF2().marking(k);

        List<Boolean> seenBefore = new ArrayList<>();

        for (int i = 0; i < k.getStates().size(); i++) {
            res.add(false);
            seenBefore.add(false);
        }

        List<State> LEU = new ArrayList<>();

        for (State s : k.getStates()) {
            if (right.get(s.getIndex())) {
                LEU.add(s);
                seenBefore.set(s.getIndex(), true);
            }
        }

        while (!LEU.isEmpty()) {
            State q = LEU.remove(0);

            res.set(q.getIndex(), true);

            for (State p : q.getPredecessors()) {
                if (!seenBefore.get(p.getIndex())) {
                    seenBefore.set(p.getIndex(), true);

                    if (left.get(p.getIndex())) {
                        LEU.add(p);
                    }
                }

            }
        }

        return res;
    }
}