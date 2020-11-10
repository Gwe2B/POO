package root.exo1;

import java.util.ArrayList;

public class ConcreteStack implements AStack {
/* --------------------------- Instance attributes -------------------------- */
    ArrayList<Object> pile = new ArrayList<Object>();

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
        {
            retour = this.peek();
            pile.remove(pile.size() - 1);
        }

        return retour;
    }
    
}
