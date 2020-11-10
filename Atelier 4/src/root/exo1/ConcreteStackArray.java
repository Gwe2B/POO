package root.exo1;

public class ConcreteStackArray implements AStack
{
/* --------------------------- Instance attributes -------------------------- */
    private Object[] pile = {};

    /**
     * Constructor by default
     */
    public ConcreteStackArray() {}

    /**
     * Constructor
     * @param arr Array for initialize the pile
     */
    public ConcreteStackArray(Object[] arr)
    { this.pile = arr; }

/* ------------------- AStack interface inherited methods ------------------- */
    @Override
    public boolean isEmpty()
    { return this.pile.length == 0; }

    @Override
    public void push(Object obj)
    {
        if(!this.isEmpty())
        {
            Object[] buff = new Object[this.pile.length + 1];
            for(int i = 0; i < this.pile.length; i++)
                buff[i] = this.pile[i];

            buff[this.pile.length] = obj;
            this.pile = buff;
        }
        else
        {
            this.pile = new Object[1];
            this.pile[0] = obj;
        }
    }

    @Override
    public Object peek()
    {
        Object retour = null;
        if(!this.isEmpty())
            retour = this.pile[this.pile.length - 1];

        return retour;
    }

    @Override
    public Object pop()
    {
        Object retour = this.peek();
        if(retour != null)
        {
            Object[] buff = new Object[this.pile.length - 1];
            for(int i = 0; i < (this.pile.length - 1); i++)
                buff[i] = this.pile[i];
                
            this.pile = buff;
        }

        return retour;
    }

/* ------------------------ Object inherited methods ------------------------ */
    @Override
    public String toString()
    {
        String retour = "{";
        for(Object val : this.pile)
        {
            retour += val.toString() + ", ";
        }
        return retour + "}";
    }
    
}
