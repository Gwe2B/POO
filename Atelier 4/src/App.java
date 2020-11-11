import java.util.ArrayList;

import root.exo1.*;

public class App {
    public static void main(String[] args)
    {
        System.out.println("=== Program start ===");

        //ConcreteStackArrayTest();
        ConcreteStackListTest();

        System.out.println("=== Program stop  ===");
    }

/* ----------------------- Exercice 1 tests functions ----------------------- */
    public static void ConcreteStackArrayTest()
    {
        // Test the parmaetered constructor
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
    }

    public static void ConcreteStackListTest()
    {
        // Test the parmaetered constructor
        ArrayList<Object> arr = new ArrayList<Object>();
        arr.add(new String("AZERTY"));
        arr.add(new String("ABC"));
        ConcreteStackList buff = new ConcreteStackList(arr);
        System.out.println("Buffer = " + buff);
        arr = null;
        buff = null;

        // Test the ConcreteStackList class
        ConcreteStackList tab = new ConcreteStackList();
        tab.push(new String("Toto"));
        tab.push(new String("Titi"));

        System.out.println("Array = " + tab);
        Object lastEl = tab.pop();

        System.out.println("Deleted element : " + lastEl);
        System.out.println("Array = " + tab);

        System.out.println("Last element of the array: " + tab.peek());

        lastEl = null;
        tab = null;
    }

/* ----------------------- Exercice 2 tests functions ----------------------- */
    //TODO: Tests function for the second exercice of the TD
}
