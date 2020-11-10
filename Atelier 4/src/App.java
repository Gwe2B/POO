import root.exo1.*;

public class App {
    public static void main(String[] args)
    {
        System.out.println("=== Program start ===");

        ConcreteStackArrayTest();
        // ConcreteStackListTest();

        System.out.println("=== Program stop  ===");
    }

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
        //TODO: Test function for the ConcreteStackList class
    }
}
