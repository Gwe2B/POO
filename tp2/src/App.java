import java.time.LocalDate;

import com.exo1.MonTableau;
import com.exo2.Citerne;
import com.exo2.CiterneSecurisee;
import com.exo2.Liquide;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Program start ===");

        testCiterneSecu();

        System.out.println("=== Program stop ===");
    }

    public static void testExo1() {
        int[] a = new int[] {1,2,3,4};
        int[] b = new int[] {-1,2,-3,4,5};

        MonTableau m1=new MonTableau(a);
        MonTableau m2=new MonTableau(b);

        System.out.println(m1.compareA(m2));
    }

    public static void testCiterne() {
        Citerne c1 = new Citerne(1000, Liquide.HUILE);
        Citerne c2 = new Citerne(1000, Liquide.VIN, LocalDate.parse("2023-01-01"));
        Citerne c3 = new Citerne(1000, Liquide.EAU, LocalDate.parse("2020-01-01"));

        try{
            System.out.println("On ajoute 2 000m^3 à c1");
            c1.ajouterLiquide(2000);
        } catch(IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("On ajoute 60% à c2");
        c2.ajouterLiquide(0.6);

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("C3: " + c3);

        System.out.println("On enleve 50% à c1");
        c1.enleverLiquide(0.5);

        try{
            System.out.println("On enleve 900m^3 à c2");
            c2.enleverLiquide(900);
        } catch(IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("C3: " + c3);

        System.out.println("C1 plus vieille que C2? " + Citerne.plusAncienne(c1, c2));
        System.out.println("C1 plus vieille que C3? " + Citerne.plusAncienne(c1, c3));

        System.out.println("Changement de liquide pour c1. (C'est meilleur le vin)");
        c1.nettoyage();
        c1.changerLiquide(Liquide.VIN);

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("C3: " + c3);

        System.out.println("Test de Citerne.equals:");
        System.out.print(c1.equals(new Citerne(1000, Liquide.VIN)));
    }

    public static void testCiterneSecu() {
        CiterneSecurisee c1 = new CiterneSecurisee(1000, Liquide.HUILE);
        CiterneSecurisee c2 = new CiterneSecurisee(1000, Liquide.VIN, LocalDate.parse("2023-01-01"));
        CiterneSecurisee c3 = new CiterneSecurisee(1000, Liquide.EAU, LocalDate.parse("2020-01-01"));

        System.out.println("On ajoute 2 000m^3 à c1");
        c1.ajouterLiquide(1050);

        System.out.println("On ajoute 60% à c2");
        c2.ajouterLiquide(0.6);

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("C3: " + c3);

        System.out.println("On enleve 50% à c1");
        c1.enleverLiquide(0.5);

        System.out.println("On enleve 900m^3 à c2");
        c2.enleverLiquide(900);

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("C3: " + c3);

        System.out.println("C1 plus vieille que C2? " + CiterneSecurisee.plusAncienne(c1, c2));
        System.out.println("C1 plus vieille que C3? " + CiterneSecurisee.plusAncienne(c1, c3));

        System.out.println("Changement de liquide pour c1. (C'est meilleur le vin)");
        c1.nettoyage();
        c1.changerLiquide(Liquide.VIN);

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("C3: " + c3);

        System.out.print("Test de CiterneSecurisee.equals:");
        System.out.println(c1.equals(new CiterneSecurisee(1000, Liquide.VIN)));

        System.out.println("Test de clonage de c3: ");
        CiterneSecurisee c4 = (CiterneSecurisee)c3.clone();
        System.out.println("C3: " + c3);
        System.out.println("C4: " + c4);
        System.out.println("C3.equals(C4): " + c3.equals(c4));
    }
}
