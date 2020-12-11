package com;

import java.util.ArrayList;

/**
 * @author Gwenaël
 * @version 1.0
 */
public class ConcreteStackList<T> implements AStack<T> {
/* --------------------------- Instance attributes -------------------------- */
    private ArrayList<T> pile;

    /**
     * Constructor by default
     */
    public ConcreteStackList()
    { this.pile = new ArrayList<T>(); }

    /**
     * Constructor
     * @param arr ArrayList for initialize the pile
     */
    public ConcreteStackList(ArrayList<T> arr)
    { this.pile = arr; }

/* ------------------- AStack interface inherited methods ------------------- */
    @Override
    public boolean isEmpty()
    { return pile.size() == 0; }

    @Override
    public void push(T obj)
    { pile.add(obj); }

    @Override
    public T peek()
    {
        T retour = null;
        if(!this.isEmpty())
            retour = pile.get(pile.size() - 1);

        return retour;
    }

    @Override
    public T pop() {
        T retour = null;
        if(!this.isEmpty())
            retour = pile.remove(pile.size() - 1);
        else
            retour = null;

        return retour;
    }
    
/* ------------------------- Object inherited method ------------------------ */
    @Override
    public String toString()
    {
        String retour = "{";
        for(int i = 0; i < this.pile.size(); i++)
            retour += this.pile.get(i).toString() + ", ";

        return retour + "}";
    }
}
