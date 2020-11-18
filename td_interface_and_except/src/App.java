import java.util.EmptyStackException;

import com.exo1.ConcreteStackArray;
import com.exo1.exception.FullStackException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Program start ===");

        try {
            Object[] arr = {new String("AZERTY"), new String("ABC")};
            ConcreteStackArray buff = new ConcreteStackArray(arr);
            System.out.println("Buffer = " + buff);
            arr = null;
            buff = null;

            // Test the ConcreteStackArray class
            ConcreteStackArray tab = new ConcreteStackArray();
            tab.push(new String("Toto"));
            tab.push(new String("Titi"));

            System.out.println("Array = " + tab);
            Object lastEl = tab.pop();

            System.out.println("Deleted element : " + lastEl);
            System.out.println("Array = " + tab);

            System.out.println("Last element of the array: " + tab.peek());

            lastEl = null;
            tab = null;
        } catch(FullStackException ex) {
            System.err.println("The stack is full! Error message:");
            System.err.println(ex.getMessage());
        } catch(EmptyStackException ex) {
            System.err.println("The stack is empty! Error message:");
            System.err.println(ex.getMessage());
        } finally {
            System.out.println("=== Program stop  ===");
        }
    }
}
