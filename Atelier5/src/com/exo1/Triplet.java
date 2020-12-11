package com.exo1;

public class Triplet<T, U, V> {
    private T element1;
    private U element2;
    private V element3;

    public Triplet(T el1, U el2, V el3) {
        this.element1 = el1;
        this.element2 = el2;
        this.element3 = el3;
    }

    public T getFirst()  { return this.element1; }
    public U getSecond() { return this.element2; }
    public V getThird()  { return this.element3; }

    @Override
    public String toString() {
        return "Triplet (" + this.element1 + ", " + this.element1 +
        ", " + this.element1 + ")";
    }
}
