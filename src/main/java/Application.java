import CTL_formula.Atomic;
import CTL_formula.CTL_Formula;
import Kripke_structure.Arc;
import Kripke_structure.KripkeStr;
import Kripke_structure.State;
import com.google.gson.GsonBuilder;
import javaCC.ParseException;
import javaCC.Parser;
import javaCC.TokenMgrError;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws IOException, URISyntaxException {

        KripkeStr k = new KripkeStr();

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
