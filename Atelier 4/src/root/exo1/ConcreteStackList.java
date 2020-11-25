package root.exo1;

import java.util.ArrayList;

/**
 * @author Gwenaël
 * @version 1.0
 */
public class ConcreteStackList implements AStack {
/* --------------------------- Instance attributes -------------------------- */
    private ArrayList<Object> pile;

    /**
     * Constructor by default
     */
    public ConcreteStackList()
    { this.pile = new ArrayList<Object>(); }

    /**
     * Constructor
     * @param arr ArrayList for initialize the pile
     */
    public ConcreteStackList(ArrayList<Object> arr)
    { this.pile = arr; }

/* ------------------- AStack interface inherited methods ------------------- */
    @Override
    public boolean isEmpty()
    { return pile.size() == 0; }

    @Override
    public void push(Object obj)
    { pile.add(obj); }

    @Override
    public Object peek()
    {
        Object retour = null;
        if(!this.isEmpty())
            retour = pile.get(pile.size() - 1);

        return retour;
    }

    @Override
    public Object pop() {
        Object retour = null;
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
