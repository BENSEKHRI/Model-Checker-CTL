package CTL_formula;

import Kripke_structure.KripkeStr;

import java.util.List;

/**
 * Class representing a Computation Tree Logic (CTL) formula.
 * A CTL formula is a formula used to specify properties of a Kripke structure.
 * <p>
 * CTL has a set of operators, including the following:
 * - EX (there exists next)
 * - AX (for all next)
 * - EF (there exists eventually)
 * - AF (for all eventually)
 * - EG (there exists globally)
 * - AG (for all globally)
 * - NOT (negation)
 * - AND (conjunction)
 * - OR (disjunction)
 */
public abstract class CTL_Formula {

    /**
     * Algorithm for marking a Kripke structure based on a CTL formula.
     * The marking algorithm traverses the Kripke structure and marks the states that satisfy the CTL formula.
     *
     * @param k The kripke structure to go through
     * @return A list of boolean representing the marking of the states (true if the state satisfies the formula, false otherwise)
     */
    public abstract List<Boolean> marking(KripkeStr k);
}
