package com.exo2;

public class Citerne{

/* ----------------------------- Class constants ---------------------------- */
    public static final int CAPACITE_MAX = 20000;

/* ---------------------------- Class attributes ---------------------------- */
    private static int identifiant = 0;

/* --------------------------- Instance attributes -------------------------- */
    public final int identifiantCiterne;
    public final int capacite;

/* --------------------------- Instance attributes -------------------------- */
    private Liquide liquide;
    
    /**
     * Citerne Constructor
     * @param capacite The citerne capacity in m^3
     * @param liquide The citerne storage liquid
     */
    public Citerne(int capacite, Liquide liquide) {
        /*
        Fait la même chose que
        ```java
        identifiantCiterne = identifiant;
        identifiant++;
        ```
        */
        this.identifiantCiterne = identifiant++;
        this.liquide = liquide;

        if(0 < capacite && capacite <= CAPACITE_MAX)
            this.capacite = capacite;
        else
            /*
            Exception  Lancé pour indiquer qu'une méthode a reçu un argument
            illégal ou inapproprié.
            */
            throw new IllegalArgumentException(
                "la capacité doit être comprise entre 1 et 20000");
    }

    /**
     * Identifiant accessor
     * @return The number of instance created
     */
    public static int getIdentifiant()
    { return identifiant; }

}
