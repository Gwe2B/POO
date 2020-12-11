package com;

/* -------------------------- This is Polymorphisme ------------------------- */
public class BoiteNonGenerique {
    private Object content;

    public BoiteNonGenerique(Object cont) {
        this.content = cont;
    }

    public Object getValue() { return this.content; }
    public void setValue(Object cont) { this.content = cont; }

    public String toString() {
        return "Object de type j'en sais rien que je ne peut pas "+
        "ecrire a la console ici";
    }
}
/* -------------------------------------------------------------------------- */
