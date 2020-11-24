import java.net.MalformedURLException;
import java.net.URL;

public class App {
    public static void main(String[] args) {
        URL hURL = null;

        System.out.println("=== Program start ===");
        try {
            hURL = new URL("https://univ-corse.fr");
            System.out.println("URL valide.");
        } catch(MalformedURLException ex) {
            System.err.print(ex.getMessage());
            System.err.println("L'URL renseigner est invalide.");
        }
        System.out.println("=== Program stop ===");
    }
}
