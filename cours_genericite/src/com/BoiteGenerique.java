package com;

public class BoiteGenerique<E> {
    private E contenue;

    public BoiteGenerique(E content) { this.contenue = content; }
    public E getContent() { return this.contenue; }
    public void setContent(E content) { this.contenue = content; }

    @Override
    public String toString() {
        return "BoiteGenerique{" +
        "Content: " + this.contenue + "}";
    }
}
