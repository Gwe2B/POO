import com.MonTableau;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Program start ===");

        int[] a = new int[] {1,2,3,4};
        int[] b = new int[] {-1,2,-3,4,5};

        MonTableau m1=new MonTableau(a);
        MonTableau m2=new MonTableau(b);
        
        System.out.println(m1.compareA(m2));

        System.out.println("=== Program stop ===");
    }
}
