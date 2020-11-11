package root.exo2;

import java.lang.Cloneable;

public class Mere implements Cloneable {
    private int i;
    private Object unObjet;

    public Mere(int entier, Object obj)
    {
        this.i = entier;
        this.unObjet = obj;
    }

/* ------------------------ Object inherited methods ------------------------ */
    @Override
    public Object clone()
    {
        return new Mere(this.i, this.unObjet);
    }
}
