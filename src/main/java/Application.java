import CTL_formula.Atomic;
import CTL_formula.CTL_Formula;
import Kripke_structure.Arc;
import Kripke_structure.KripkeStr;
import Kripke_structure.State;
import javaCC.ParseException;
import javaCC.Parser;
import javaCC.TokenMgrError;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // Création de la strucutre de Kripke

        Atomic a = new Atomic("a");
        Atomic b = new Atomic("b");

        State s0 = new State(0, "s0", Set.of(a, b), true);
        State s1 = new State(1, "s1", Set.of(a), false);
        State s2 = new State(2, "s2", Set.of(b), false);
        State s3 = new State(3, "s3", Set.of(a, b), false);

        Arc a0 = new Arc(s0, s1);
        Arc a1 = new Arc(s1, s2);
        Arc a2 = new Arc(s2, s3);
        Arc a3 = new Arc(s3, s0);
        Arc a4 = new Arc(s0, s2);

        KripkeStr k = new KripkeStr(List.of(s0, s1, s2, s3), List.of(a0, a1, a2, a3, a4));

        k.setSrcDestState();

        Parser parser = new Parser(System.in);

        while (true) {
            try {
                // Initialiser les formules avec javaCC
                CTL_Formula f = parser.mainNT();

                System.out.println(f);

                // Test des algos de marquage
                List<Boolean> checkCTL = f.marking(k);

                System.out.println("The states that verify the CTL formula are: ");

                for (State s : k.getStates()) {
                    if (checkCTL.get(s.getIndex())) {
                        System.out.println(" - " + s + " - ");
                    }
                }

                System.out.println("----------");

            } catch (TokenMgrError e) {
                System.out.println("Error - The label must be in miniscule !");
                return;
            } catch (ParseException e) {
                System.out.println("Error - This is not a CTL formula !");
                return;
            }
        }
    }
}
