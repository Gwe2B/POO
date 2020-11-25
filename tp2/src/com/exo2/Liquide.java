package com.exo2;

public enum Liquide {//classse enumération des liquide
    EAU("eau", 10), 
    VIN("vin", 15),
    HUILE("huile", 9);

    private String nom;
    private int temperature;

    /**
     * Constructor
     * @param nom The liquid's name
     * @param temperature The liquid ideal conservation temperature
     */
    private Liquide(String nom, int temperature) {
        this.nom = nom;
        this.temperature = temperature;
    }

/* --------------------------- Accessor & mutator --------------------------- */
    /**
     * Name Accessor
     * @return The liquid's name
     */
    public String getNom()
    { return nom; }

    /**
     * Temperature accessor
     * @return The ideal temperature of conservation
     */
    public int getTemperature()
    { return temperature; }

/* ------------------------ Object inherited methods ------------------------ */
    @Override
    public String toString()
    { return "le nom du liquide est : " + nom; }
}
