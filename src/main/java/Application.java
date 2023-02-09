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

        KripkeStr k = Application.ReadJson(Path.of(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("Data.json")).toURI()));

        System.out.println(k);

        System.out.println("-----------------");

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

    public static KripkeStr ReadJson(Path filename) throws IOException {
        String json = Files.readString(filename);
        final Gson gson = new GsonBuilder().create();
        final JsonKripkeStr jsonKripkeStr = gson.fromJson(json, JsonKripkeStr.class);

        List<Arc> arcs = jsonKripkeStr.arcs.stream().map(a -> new Arc(a.get(0), a.get(1))).toList();
        List<State> states = jsonKripkeStr.states.stream().map(s -> new State(s.nom, s.labels.stream().map(Atomic::new).collect(Collectors.toSet()), s.isInitial)).toList();

        KripkeStr kripkeStr = new KripkeStr(states, arcs);
        kripkeStr.setSrcDestState();

        return kripkeStr;
    }


    public static class JsonKripkeStr {
        public ArrayList<JsonState> states;
        public ArrayList<ArrayList<Integer>> arcs;
    }

    public static class JsonState {
        public String nom;
        public boolean isInitial;
        public ArrayList<String> labels = new ArrayList<>();
    }
}
