package CTL_formula;

import Kripke_structure.KripkeStr;

import java.util.List;

public abstract class CTL_Formula {
    public abstract List<Boolean> marking (KripkeStr k);
}
