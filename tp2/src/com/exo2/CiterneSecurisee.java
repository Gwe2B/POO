package com.exo2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CiterneSecurisee extends Citerne implements Cloneable {

/* --------------------------- Instance attribute --------------------------- */
    private Citerne cuvTropPlein;

/* ------------------------------ Constructors ------------------------------ */
    /**
     * Constructor with default value for creation date
     * @param capacite the capacity of the citerne
     * @param liquide the liquid in the citerne in m^3
     * @param date the date of creation
     */
    public CiterneSecurisee(int capacite, Liquide liquide)
    { this(capacite, liquide, (int)(capacite * 0.1), LocalDate.now()); }
    
    /**
     * Constructor with default value for creation date
     * @param capacite the capacity of the citerne
     * @param liquide the liquid in the citerne in m^3
     * @param cuvTropPlain the trop plein capacity in m^3
     */
    public CiterneSecurisee(int capacite, Liquide liquide, int cuvTropPlein)
    { this(capacite, liquide, cuvTropPlein, LocalDate.now()); }

    /**
     * Constructor with default value for creation date
     * @param capacite the capacity of the citerne
     * @param liquide the liquid in the citerne in m^3
     * @param date the date of creation
     */
    public CiterneSecurisee(int capacite, Liquide liquide, LocalDate date)
    { this(capacite, liquide, (int)(capacite * 0.1), date); }

    /**
     * Constructor with default value for creation date
     * @param capacite the capacity of the citerne
     * @param liquide the liquid in the citerne in m^3
     * @param cuvTropPlain the trop plein capacity in m^3
     * @param date the date of creation
     */
    public CiterneSecurisee(int capacite, Liquide liquide, int cuvTropPlein, LocalDate date)
    {
        super(capacite, liquide, date);
        this.setCuvTropPlein(cuvTropPlein);
    }

/* ---------------------------- Instance methods ---------------------------- */
    private void verifyTropPleinLvl() {
        int qtyTropPlein = this.cuvTropPlein.getStock();
        if(qtyTropPlein >= (int)(qtyTropPlein/2))
            System.err.println("Attention la cuve de trop plein doit être " +
                "vidangé! (Capacité à 50% du MAX)");
    }

    public void setCuvTropPlein(int capacity) {
        if(capacity > 0 && capacity < this.capacite) {
            this.cuvTropPlein = new Citerne(
                capacity,
                this.getLiquide()
            );
        } else {
            this.cuvTropPlein = new Citerne(
                (int)(this.capacite * 0.1),
                this.getLiquide()
            );

            System.err.println("La capacite de la cuve de trop plein est invalide. " +
                "Cuve de trop plein a 10% de la citerne créer.");
        }
    }

    public Citerne getCuvTropPlein()
    { return cuvTropPlein; }

/* ------------------------ Citerne inherited methods ----------------------- */

    @Override
    public void ajouterLiquide(double percent){
        if(this.flag_nettoyage)
            this.flag_nettoyage = false;

        if(percent >= 0. && percent <= 1.) {
            this.stock += (int)(this.capacite * percent);

            if(this.stock > this.capacite) {
                this.cuvTropPlein.ajouterLiquide(this.capacite - this.stock);
                System.err.println("Attention la cuve déborde dans le trop plein");
                this.verifyTropPleinLvl();
            }
        }
        else{
            throw new IllegalArgumentException("la valeur passer en parametre doit etre comprise entre 0 et 1 inclus");
        }
    }

    @Override
    public void ajouterLiquide(int qty) {
        if(this.flag_nettoyage)
            this.flag_nettoyage = false;
 
        if(qty >= 0) {
            this.stock += qty;

            if(this.stock > this.capacite) {
                this.cuvTropPlein.ajouterLiquide(this.stock - this.capacite);
                System.err.println("Attention la cuve déborde dans le trop plein");
                this.verifyTropPleinLvl();
            }
        }
        else{
            throw new IllegalArgumentException("la valeur passer en parametre doit etre superieur ou egale a 0");
        }
    }

    @Override
    public void enleverLiquide(double percent) {
        if(percent >= 0. && percent <= 1.) {
            int toRetire = (int)(capacite * percent);
            int qtyTropPlein = this.cuvTropPlein.getStock();

            if(qtyTropPlein >= toRetire) {
                this.cuvTropPlein.enleverLiquide(toRetire);   
            } else {
                toRetire -= qtyTropPlein;
                this.cuvTropPlein.enleverLiquide(qtyTropPlein);
                this.stock -= toRetire;
            }
        } else {
            throw new IllegalArgumentException("la valeur passer en parametre doit etre comprise entre 0 et 1 inclus");
        }
    }

    @Override
    public void enleverLiquide(int qty) {
        if(qty >= 0) {
            int qtyTropPlein = this.cuvTropPlein.getStock();

            if(qtyTropPlein >= qty) {
                this.cuvTropPlein.enleverLiquide(qty);   
            } else {
                qty -= qtyTropPlein;
                this.cuvTropPlein.enleverLiquide(qtyTropPlein);
                this.stock -= qty;
            }
        } else {
            throw new IllegalArgumentException("la valeur passer en parametre doit etre superieur ou egale a 0");
        }
    }

    @Override
    public void nettoyage() {
        this.stock = 0;
        this.flag_nettoyage = true;

        this.cuvTropPlein.nettoyage();
    }

    @Override
    public boolean changerLiquide(Liquide liquide) {
        boolean result = super.changerLiquide(liquide);
        result = result && this.cuvTropPlein.changerLiquide(liquide);

        return result;
    }
    
/* ------------------------ Object inherited methods ------------------------ */

    @Override
    public Object clone() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CiterneSecurisee result = new CiterneSecurisee(
            this.capacite,
            this.liquide,
            LocalDate.parse(this.creation.format(formatter))
        );

        result.cuvTropPlein = new Citerne(
            this.cuvTropPlein.capacite,
            this.liquide,
            LocalDate.parse(this.cuvTropPlein.creation.format(formatter))
        );

        result.flag_nettoyage = this.flag_nettoyage;
        result.cuvTropPlein.flag_nettoyage = this.cuvTropPlein.flag_nettoyage;
        result.cuvTropPlein.stock = (this.cuvTropPlein.getStock());
        result.stock = this.stock;

        return (Object)result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eval;
		
		if(this == obj)
			eval = true;
		else if(obj == null || this.getClass() != obj.getClass())
			eval = false;
		else
		{
			CiterneSecurisee hCiterne = (CiterneSecurisee)obj;
            eval = this.capacite == hCiterne.capacite &&
                this.creation.equals(hCiterne.creation) &&
                this.stock == hCiterne.stock &&
                this.liquide.equals(hCiterne.liquide) &&
                this.cuvTropPlein.equals(hCiterne.cuvTropPlein);
		}
		
		return eval;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Citerne n°" + this.identifiantCiterne +
        ", " + this.liquide + ", capacité: " + this.capacite + " m3, " + 
        "mise en service: " + this.creation.format(formatter) + ", volume occupé: " +
        this.capacite + " m3. \n Cuve de trop plein: {\n" + this.cuvTropPlein + "\n}";
    }
}
