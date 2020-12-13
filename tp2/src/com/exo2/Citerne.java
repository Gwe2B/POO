package com.exo2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.exo1.EstComparable;

public class Citerne implements EstComparable{

/* ----------------------------- Class constants ---------------------------- */
    public static final int CAPACITE_MAX = 20000;

/* ---------------------------- Class attributes ---------------------------- */
    private static int identifiant = 0;

/* ---------------------------- Instance constant --------------------------- */
    public final LocalDate creation;
    public final int identifiantCiterne;
    public final int capacite;

/* --------------------------- Instance attributes -------------------------- */
    protected Liquide liquide;
    protected boolean flag_nettoyage = true;
    protected int stock;

/* ------------------------------ Constructors ------------------------------ */
    
    /**
     * Constructor with date default value (LocalDate.now())
     * @param capacite The citerne capacity in m^3
     * @param liquide The citerne storage liquid
     */
    public Citerne(int capacite, Liquide liquide)
    { this(capacite, liquide, LocalDate.now()); }

    /**
     * Citerne Constructor
     * @param capacite The citerne capacity in m^3
     * @param liquide The citerne storage liquid
     */
    public Citerne(int capacite, Liquide liquide, LocalDate date) {
        /*
        Fait la même chose que
        ```java
        identifiantCiterne = identifiant;
        identifiant++;
        ```
        */
        this.identifiantCiterne = identifiant++;
        this.creation = date;
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

/* ---------------------------- Instance methods ---------------------------- */
    
    /**
     * Nettoie la citerne
     */
    public void nettoyage() {
        this.stock = 0;
        this.flag_nettoyage = true;
    }

    /**
     * Change le liquide de la cuve
     * @param liquide Le nouveau liquide
     * @return True si la cuve à d'abord ete nettoyer (et donc le changement à
     *  bien été fait), False sinon
     */
    public boolean changerLiquide(Liquide liquide) {
        boolean result = false;

        if(this.flag_nettoyage) {
            result = true;
            this.liquide = liquide;
        }

        return result;
    }

    /**
     * Ajoute du liquide de la citerne
     * @param percent Pourcentage par rapport a la capacite totale de la cuve
     */
    public void ajouterLiquide(double percent){
        if(this.flag_nettoyage)
            this.flag_nettoyage = false;

        if(percent >= 0. && percent <= 1.) {
            int buf_stock = stock + (int)(capacite * percent);
            if(buf_stock > this.capacite) {
                this.stock = this.capacite;
                throw new IllegalArgumentException("La cuve déborde, " +
                    (buf_stock - this.capacite) + "m3 en trop");
            } else {
                this.stock = buf_stock;
            }
        }
        else{
            throw new IllegalArgumentException("la valeur passer en parametre doit etre comprise entre 0 et 1 inclus");
        }
    }

    /**
     * Ajoute du liquide de la citerne
     * @param qty Volume en m3
     */
    public void ajouterLiquide(int qty) {
        if(this.flag_nettoyage)
            this.flag_nettoyage = false;

        if((this.stock + qty) >= 0 && (this.stock + qty) <= this.capacite)
            this.stock += qty;
        else
        {
            this.stock = this.capacite;
            throw new IllegalArgumentException(
                "La valeur passer en paramètre ne doit pas faire deéborder la citerne. " + 
                ((this.stock + qty) - this.capacite) + " m^3 en trop."
            );
        }
    }

    /**
     * Enleve du liquide de la citerne
     * @param percent Pourcentage par rapport a la capacite totale de la cuve
     */
    public void enleverLiquide(double percent) {
        if(percent >= 0. && percent <= 1.) {
            int buf_stock = stock - (int)(capacite * percent);
            if(buf_stock < 0) {
                this.stock = 0;
                throw new IllegalArgumentException("La cuve n'est pas assez pleine, " +
                    (buf_stock) + "m3 en trop");
            } else {
                this.stock = buf_stock;
            }
        }
        else{
            throw new IllegalArgumentException("la valeur passer en parametre doit etre comprise entre 0 et 1 inclus");
        }
    }

    /**
     * Enleve du liquide de la citerne
     * @param qty Volume en m3
     */
    public void enleverLiquide(int qty) {
        if((this.stock - qty) >= 0 && (this.stock - qty) <= this.capacite)
            this.stock -= qty;
        else
        {
            qty -= this.stock;
            this.stock = 0;
            throw new IllegalArgumentException(
                qty + " m^3 manquant pour satisfaire." +
                "La cuve à été entierrement vidé."
            );
        }
    }

    /**
     * Liquide accessor
     * @return Liquide
     */
    public Liquide getLiquide()
    { return liquide; }

    /**
     * Quantite stocke accessor
     * @return un entier representant la quantite stocke
     */
    public int getStock()
    { return this.stock; }

/* --------------------------- Interfaces methods --------------------------- */

    /**
     * Compare the instance to another object in capacity & quantity stored
     * @param obj The object to compare with
     * @return 1 if obj is greather than the instance, -1 if is smaller,
     *  0 if equals
     */
    @Override
    public int compareA(Object obj) {
        int eval = 0;
        
        if(obj instanceof Citerne) {
            Citerne hCiterne = (Citerne)obj;
            
            if(this.stock < hCiterne.stock)
                eval = -1;
            else if(this.stock > hCiterne.stock)
                eval = 1;
            else {
                if(this.capacite < hCiterne.capacite)
                    eval = -1;
                else if(this.capacite > hCiterne.capacite)
                    eval = 1;
            }
        }
        else
            throw new IllegalArgumentException(
                "Le parametre n'est pas comparable");
        
        return eval;
    }

/* ------------------------ Object inherited methods ------------------------ */

    @Override
    public boolean equals(Object obj) {
        boolean eval;
		
		if(this == obj)
			eval = true;
		else if(obj == null || this.getClass() != obj.getClass())
			eval = false;
		else
		{
			Citerne hCiterne = (Citerne)obj;
            eval = this.capacite == hCiterne.capacite &&
                this.creation.equals(hCiterne.creation) &&
                this.stock == hCiterne.stock &&
                this.liquide.equals(hCiterne.liquide);
		}
		
		return eval;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Citerne n°" + this.identifiantCiterne +
        ", " + this.liquide + ", capacité: " + this.capacite + " m3, " + 
        "mise en service: " + this.creation.format(formatter) + ", volume occupé: " +
        this.stock + " m3";
    }

/* ------------------------------ Class mathods ----------------------------- */

    /**
     * Identifiant accessor
     * @return The number of instance created
     */
    public static int getIdentifiant()
    { return identifiant; }

    /**
     * Compare l'age de deux citernes
     * @param citerneA
     * @param citerneB
     * @return True si la Citerne A est plus vieille, false sinon
     */
    public static boolean plusAncienne(Citerne citerneA, Citerne citerneB){                             
        return citerneA.creation.compareTo(citerneB.creation) < 0;
    }
}
