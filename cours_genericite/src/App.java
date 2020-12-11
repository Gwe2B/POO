import com.ConcreteStackList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== PROGRAM START ===");

        ConcreteStackList<Integer> arr = new ConcreteStackList<>();
        arr.push(50);
        arr.pop();
        arr.peek();

        System.out.println("=== PROGRAM STOP ===");
    }
}
