import java.io.FileNotFoundException;
import java.util.*;
import com.exo1.*;
import com.exo2.*;
import com.exo3.*;
import com.exo4.WordSort;

public class App {
    public static void main(String[] args) throws Exception {
        // App.exo1()
        // App.exo2()
        // App.exo3()
        App.exo4();
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
        Anagramme an = new Anagramme("dictionary.txt", 2);
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
}
