import java.util.*;
import com.exo1.*;
import com.exo2.*;
import com.exo3.*;
import com.exo4.*;
import com.exo5.*;

public class App {
    public static void main(String[] args) throws Exception {
        // App.exo1();
        App.exo2();
        // App.exo3();
        // App.exo4();
        // App.exo5();
    }

    public static void exo1() {
        List<Pair<Integer, String>> toto = new ArrayList<Pair<Integer, String>>();
        toto.add(new Pair(10, "Toto"));
        toto.add(new Pair(20, "Toti"));
        toto.add(new Pair(10, "Totu"));

        System.out.println(toto.get(0).getEl1());
        System.out.println(toto.get(0).getEl2());

        toto.get(1).setEl1(100);
        toto.get(1).setEl2("Test");
        System.out.println(toto.get(1).getEl1());
        System.out.println(toto.get(1).getEl2());
    }

    public static void exo2() {
        /**
         * Pour faciliter le debuggage nous avons décider d'utiliser une version
         * alléger du fichier fournit se limittant aux 5 000 premieres lignes.
         */
        Anagramme an = new Anagramme("dictionary_new.txt", 2);
        System.out.println(an.getAnagrammes());
    }

    public static void exo3() {
        // RandomList rdlst = new RandomList(15);
        // System.out.println(rdlst.getCollection());
        RandomSet rdlst = new RandomSet(15);
        System.out.println(rdlst.getCollection());
    }

    public static void exo4() {
        String sortAlgorythm;
        String buf = "Toto";
        Scanner scan = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<String>();

        while(buf.length() > 0) {
            System.out.print("Ajouter un mot (mot vide = STOP): ");
            buf = scan.nextLine();

            if(buf.length() > 0)
                arr.add(buf);
        }

        System.out.print("Quel algo de trie voulez vous utiliser? [LEXI/REVERSED/MILI]: ");
        sortAlgorythm = scan.nextLine();

        switch(sortAlgorythm.toUpperCase()){
            case "LEXI":
                arr.sort(WordSort.LEXICAL_COMPARATOR);
                System.out.println("Lexicograhic order: " + arr);
                break;

            case "REVERSED": 
                arr.sort(WordSort.REVERSED_LEXICAL_COMPARATOR);
                System.out.println("Reversed lexicograhic order: " + arr);
                break;

            case "MILI":
                arr.sort(WordSort.MILITARY_COMPARATOR);
                System.out.println("Military order: " + arr);
                break;

            default:
                System.err.println("Algo inconnue!!");
                break;
        }
    }

    public static void exo5() {
        Personne a = new Personne("GUIRAUD", "Gwe", 23, 05, 2000, 0, "", "", "");
        Personne b = new Personne("GUIRAUD", "Maelle", 18, 12, 2002, 0, "", "", "");
        Personne c = new Personne("GUIRAUD", "Maelis", 10, 05, 2008, 0, "", "", "");
        Personne d = new Personne("GUIRAUD", "Toto", 10, 05, 2008, 0, "", "", "");
        Personne e = new Personne("GUIRAUD", "Tata", 10, 05, 2008, 0, "", "", "");

        System.out.println("a.compareTo(b) = " + a.compareTo(b));
        System.out.println("b.compareTo(c) = " + b.compareTo(c));
        System.out.println("c.compareTo(a) = " + c.compareTo(a));
        System.out.println("c.compareTo(b) = " + c.compareTo(b));
        System.out.println("c.compareTo(c) = " + c.compareTo(c));

        System.out.println("c.compareTo(d) = " + c.compareTo(d));
        System.out.println("c.compareTo(e) = " + c.compareTo(e));
        System.out.println("d.compareTo(e) = " + d.compareTo(e));
    }
}
