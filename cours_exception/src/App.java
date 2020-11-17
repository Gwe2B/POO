import java.net.URI;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws Exception {
        URI hURI = null;

        System.out.println("=== Program start ===");
        try {
            hURI = new URI("https://univ-corse.fr");
            System.out.println("URI valide.");
        } catch(URISyntaxException ex) {
            System.err.println("L'URI renseigner est invalide.");
        }
        System.out.println("=== Program stop ===");
    }
}
