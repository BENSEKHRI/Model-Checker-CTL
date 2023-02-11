# Model-Checker-CTL

Bienvenue dans le projet Model-Checker-CTL, un outil pour vérifier les propriétés d'une structure de Kripke en utilisant
la logique arbre de calcul (CTL).

## Auteurs

|    Prénom     |    Nom    | N° étudiant |
|:-------------:|:---------:|:-----------:|
| Mohand Lounis | BENSEKHRI |  11710457   |
|     Salem     | BOUDEBABA |  12017165   |
|    Younes     |  IBIZZI   |  12212407   |
|    Bingqin    |   ZHANG   |  11707768   |

## Installation

Pour utiliser Model-Checker-CTL, vous avez besoin des éléments suivants :

* JDK (Java Development Kit) version 8 ou supérieure
* IDE (Integrated Development Environment) telle que Eclipse, IntelliJ IDEA, ou NetBeans

### Étape 1 : Téléchargez le code source

Téléchargez le code source de Model-Checker-CTL à partir du dépôt GitHub. Vous pouvez le faire en clonant le dépôt ou en
téléchargeant un fichier ZIP.

```bash
   git clone git@github.com:BENSEKHRI/Model-Checker-CTL.git
   git clone https://github.com/BENSEKHRI/Model-Checker-CTL.git
```

### Étape 2 : Ouvrez le projet dans votre IDE

Ouvrez le projet de Model-Checker-CTL dans votre IDE préféré. Si vous avez téléchargé un fichier ZIP, décompressez-le et
ouvrez-le comme projet existant dans votre IDE.

### Étape 3 : Exécutez le projet

Une fois le projet ouvert dans votre IDE, exécutez-le en utilisant le fichier ```Application``` comme point d'entrée.
Vous devriez voir une sortie de console indiquant que le projet s'est exécuté avec succès.

### Étape 4 : Commencez à utiliser Model-Checker-CTL

Vous pouvez maintenant utiliser Model-Checker-CTL pour vérifier des modèles CTL. Consultez la documentation du projet
pour plus d'informations sur l'utilisation de l'outil.

## Fonctionnalités

* Chargement de structure de Kripke à partir de fichiers JSON
* Possibilité de chargement d'une autre structure de Kripke sans arrêter le programme
* Affichage de structure de Kripke sous format PNG
* Spécification de propriétés à vérifier en utilisant les formules CTL
* Marquage des états de la structure de Kripke qui satisfont la formule spécifiée
* Affichage des résultats de marquage

## Utilisation

Pour utiliser Model-Checker-CTL, vous devez d'abord spécifier la structure de Kripke que vous souhaitez vérifier en
utilisant un fichier JSON. Vous pouvez ensuite spécifier les propriétés à vérifier en utilisant des formules CTL que
vous taperez directement sur la console. Le programme effectuera ensuite un marquage des états qui satisfont les
propriétés spécifiées et affichera les résultats de marquage.

Pour remplir le fichier JSON de la structure de Kripke, sachez que les index des états sont incrémentés automatiquement
et commence à 0. Donc dans la partie des arcs, pour relier votre premier état avec le second (en sachant que l'ordre des
états est celui sur vous déclarer dans le JSON : le premier est celui qui est tous en haut), il faut écrire [0, 1].

Si vous voulez tester une autre structure de Kripke pendant l'exécution de l'application, vous pouvez le faire sans
arrêter le programme, et cela, en chargeant directement votre fichier JSON contenant la nouvelle SK via le Menu SK.
Sachez toutefois que le fichier JSON doit être bien syntaxé et doit être présent dans le dossier src/main/resources
faute de quoi le programme s'arrête avec une erreur.

Pour avoir une vue image sur votre structure de kripke n'hésitez pas à l'afficher via le Menu Formules CTL et ainsi vous
aurez un aperçu PNG de celle-ci.

Vous pouvez tester autant de formules que vous souhaitez, à chaque fois que cela se fait vous aurez un aperçu d'une
formule équivalente et ensuite l'ensemble des états qui la satisfont (On affiche les noms des états).

Toutes les étapes sont expliquées dans les notices de chaque Menu, si vous rencontrez des difficultés n'hésitez pas à
les lire.

Sur ce, amusez-vous bien !

## Formules CTL

### À savoir :

* Les espaces, les tabulations et les retours chariots sont ignorés.
* Un <LABEL> doit obligatoirement être écrit en minuscule.
* Une formule appliquée à un opérateur doit obligatoirement être entre parenthèses.

Les formules CTL (F, F1, F2) peuvent être spécifiées en utilisant les opérateurs suivants :

* TRUE | FALSE
* ~ F NOT  (négation)
* F1 /\ F2 (conjonction)
* F1 \/ F2 (disjonction)
* F1 => F2 (implication)
* EX F (il existe suivant)
* AX F (pour tout suivant)
* EF F (il existe finalement)
* AF F (pour tout finalement)
* EG F (il existe globalement)
* AG F (pour tout globalement)
* E (F1 U F2)  (il existe until)
* A (F1 U F2)  (pour tout until)

#### Notez Bien :

Si vous faites une erreur dans l'écriture de vos formules CTL le programme se termine avec une erreur, alors faites
gaffent !

## Documentation

La documentation complète du code se trouve dans les commentaires du code source.

## Contribution

Les contributions à Model-Checker-CTL sont les bienvenues. Si vous souhaitez apporter une contribution, merci de forker
le dépôt et de soumettre une demande de modification.
