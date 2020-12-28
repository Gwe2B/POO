package com.exo1;

/**
 * Pair
 */
public class Pair<U, L> {
    private U el1;
    private L el2;

    public Pair(U el1, L el2) {
        this.setEl1(el1); 
        this.setEl2(el2); 
    }

/* ---------------------------- Accesor & mutator --------------------------- */

    public void setEl1(U el1) { this.el1 = el1; }
    public void setEl2(L el2) { this.el2 = el2; }

    public U getEl1() { return this.el1; }
    public L getEl2() { return this.el2; }
}