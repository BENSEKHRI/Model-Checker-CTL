import CTL_formula.Atomic;
import CTL_formula.CTL_Formula;
import Kripke_structure.Arc;
import Kripke_structure.KripkeStr;
import Kripke_structure.State;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javaCC.ParseException;
import javaCC.Parser;
import javaCC.TokenMgrError;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    public static void main(String[] args) throws URISyntaxException, IOException {
        KripkeStr k = new KripkeStr();
        Parser parser = new Parser(System.in);

        Scanner scan = new Scanner(System.in);
        boolean quit = false;

        String message = "+-------------------------------------------+\n|\033[34m           MODEL   CHECKER   CTL           \033[0m|\n+-------------------------------------------+\n";
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            // Thread.sleep(10);
        }

        while (!quit) {

            System.out.println("\n            +-------------------+");
            System.out.println("            |  Menu  Principal  |");
            System.out.println("+-----------+-------------------+-----------+");
            if (!k.getStates().isEmpty()) {
                System.out.println("| 1. Structure de Kripke           \033[32m[OK]\033[0m     |");
            } else {
                System.out.println("| 1. Structure de Kripke                    |");
            }

            if (!k.getStates().isEmpty()) {
                System.out.println("| 2. Formules CTL             \033[32m[Activer]\033[0m     |");
            } else {
                System.out.println("| 2. Formules CTL             \033[31m[Désactiver]\033[0m  |");
            }
            System.out.println("| 3. Notice                                 |");
            System.out.println("| 4. Quitter                                |");
            System.out.println("+-------------------------------------------+");
            System.out.print("   * Entrez votre choix: ");

            int mainChoice = scan.nextInt();

            System.out.println("\n");

            switch (mainChoice) {
                case 1:
                    boolean backToMain = false;
                    while (!backToMain) {
                        System.out.println("\n            +-------------------+");
                        System.out.println("            |     Menu * SK     |");
                        System.out.println("+-----------+-------------------+-----------+");
                        System.out.println("| 1. Charger une SK depuis un JSON          |");
                        System.out.println("| 2. Afficher la SK                         |");
                        System.out.println("| 3. Retour au Menu Principal               |");
                        System.out.println("+-------------------------------------------+");
                        System.out.print("   * Entrez votre choix: ");

                        int SKChoice = scan.nextInt();

                        System.out.println("\n");

                        switch (SKChoice) {
                            case 1 -> {
                                boolean backToSKMenu = false;
                                while (!backToSKMenu) {
                                    if (!k.getStates().isEmpty()) {
                                        System.out.println("+-------------------------------------------+");
                                        System.out.println("| \033[33mUne structure de Kripke est déjà chargée.\033[0m |");
                                        System.out.println("+-------------------------------------------+");
                                        System.out.println("| 1. Charger une nouvelle SK depuis un JSON |");
                                        System.out.println("| 2. Retour au Menu SK                      |");
                                        System.out.println("+-------------------------------------------+");
                                        System.out.print("   * Entrez votre choix: ");

                                        int loadSKChoice = scan.nextInt();
                                        System.out.println("\n");

                                        switch (loadSKChoice) {
                                            case 1 -> {
                                                k = menuSK1();
                                                backToSKMenu = true;
                                            }
                                            case 2 -> backToSKMenu = true;
                                            default ->
                                                    System.out.println("+-------------------------------------------+\n|      * Choix invalide. Réessayez. *       |\n+-------------------------------------------+\n");
                                        }
                                    } else {
                                        k = menuSK1();
                                        backToSKMenu = true;
                                    }
                                }
                            }
                            case 2 -> menuSK2(k);
                            case 3 -> backToMain = true;
                            default ->
                                    System.out.println("+-------------------------------------------+\n|      * Choix invalide. Réessayez. *       |\n+-------------------------------------------+\n");
                        }
                    }
                    break;
                case 2:
                    if (!k.getStates().isEmpty()) {
                        backToMain = false;
                        while (!backToMain) {
                            System.out.println("\n            +-------------------+");
                            System.out.println("            |     Menu * CTL    |");
                            System.out.println("+-----------+-------------------+-----------+");
                            System.out.println("| 1. Vérifier une formule CTL               |");
                            System.out.println("| 2. Notice                                 |");
                            System.out.println("| 3. Retour au Menu Principal               |");
                            System.out.println("+-------------------------------------------+");
                            System.out.print("   * Entrez votre choix: ");

                            int CTLChoice = scan.nextInt();

                            System.out.println("\n");

                            switch (CTLChoice) {
                                case 1 -> menuCTL1(k, parser);
                                case 2 -> System.out.println("Voici le Notice des formules CTL");
                                case 3 -> backToMain = true;
                                default ->
                                        System.out.println("+-------------------------------------------+\n|      * Choix invalide. Réessayez. *       |\n+-------------------------------------------+\n");
                            }
                        }
                    } else {
                        System.out.println("\033[31m+-------------------------------------------+\n| Erreur : Aucune SK n'a été renseignée.    |\n+-------------------------------------------+\n\033[0m");
                    }
                    break;
                case 3:
                    System.out.println("Voici le Notice du MD-CTL");
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("+-------------------------------------------+\n|      * Choix invalide. Réessayez. *       |\n+-------------------------------------------+\n");
            }
        }
        System.out.println("+-------------------------------------------+\n|       Fermeture de l'application...       |\n+-------------------------------------------+\n");
    }

    public static KripkeStr menuSK1() throws URISyntaxException, IOException {
        System.out.println("+-------------------------------------------+\n|    \033[32mChargement d'une SK depuis un JSON\033[0m     |\n+-------------------------------------------+");

        Scanner scanner = new Scanner(System.in);
        System.out.println("+-------------------------------------------+");
        System.out.println("|  \033[33m(NB : Le fichier JSON doit être dans le\033[0m  |");
        System.out.println("|    \033[33msous-répertoire src/main/resources )\033[0m   |");
        System.out.println("+-------------------------------------------+");
        System.out.print("   * Entrez le nom du fichier JSON : ");

        String filePathString = scanner.nextLine();

        return ReadJson(Path.of(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(filePathString)).toURI()));
    }

    public static void menuSK2(KripkeStr k) {
        System.out.println("+-------------------------------------------+\n|    \033[32mAffichage de la Structure de Kripke\033[0m    |\n+-------------------------------------------+");

        System.out.println(k);
    }

    public static void menuCTL1(KripkeStr k, Parser parser) {
        System.out.println("+-------------------------------------------+\n|       \033[32mVérification des formules CTL\033[0m       |\n+-------------------------------------------+");

        System.out.println("   * Entrez une formule CTL : ");

        try {
            CTL_Formula ctlFormula = parser.mainNT();

            System.out.print("\n => Cette formule est équivalente à : \n" + ctlFormula + "\n");

            // Algos of the markings
            List<Boolean> checkCTL = ctlFormula.marking(k);

            System.out.println("\nLes états qui vérifient la formule CTL sont : \n");

            System.out.println(k.getStates().stream().filter(s -> checkCTL.get(s.getIndex())).toList() + "\n");
        } catch (TokenMgrError e) {
            System.out.println("+-------------------------------------------+\n| \033[31mErreur - Le label doit être en minuscule\033[0m  |\n+-------------------------------------------+");
            System.exit(1);
        } catch (ParseException e) {
            System.out.println("+-------------------------------------------+\n| \033[31mErreur - Ceci n'est pas une formule CTL\033[0m   |\n+-------------------------------------------+");
            System.exit(1);
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
