import com.exo1.Triplet;
import utils.exo2.Hasard;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== PROGRAM START ===");

        Triplet<Integer, String, Double> tr =
            new Triplet<Integer, String, Double>(5, "Toto", 10.2);
        
        System.out.println("First element: " + tr.getFirst());
        System.out.println("Second element: " + tr.getSecond());
        System.out.println("Third element: " + tr.getThird());

        System.out.println("Triplet: " + tr);

        /*Integer[] intArr = {0, 2, 4, 6, 8, 10};
        String[] strArr  = {"a", "b", "c", "d"};

        System.out.println("Random in Integer array: " + Hasard.choice(intArr));
        System.out.println("Random in String array: "  + Hasard.choice(strArr));*/

        System.out.println("=== PROGRAM STOP ===");
    }
}
