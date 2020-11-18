package com.exo1;

import java.util.EmptyStackException;

import com.exo1.exception.FullStackException;

public class ConcreteStackArray implements AStackV2
{
/* ----------------------------- Class Constants ---------------------------- */
    public static final int STACK_SIZE = 100;

/* --------------------------- Instance attributes -------------------------- */
    private Object[] pile;
    private int endStackPtr;

    /**
     * Constructor by default
     */
    public ConcreteStackArray()
    { this(new Object[ConcreteStackArray.STACK_SIZE]); }

    /**
     * Constructor
     * @param arr Array for initialize the pile
     */
    public ConcreteStackArray(Object[] arr)
    {
        int i = 0;
        boolean flag = true;

        if(arr.length == ConcreteStackArray.STACK_SIZE)
        {
            this.pile = arr;
            while(flag && i < ConcreteStackArray.STACK_SIZE)
            {
                if(this.pile == null)
                {
                    this.endStackPtr = i - 1;
                    flag = false;
                }
                
                i++;
            }
        }
        else
            System.err.println("The stack size must be of " +
                ConcreteStackArray.STACK_SIZE + "element!");
    }

/* ------------------- AStack interface inherited methods ------------------- */
    @Override
    public boolean isEmpty()
    { return this.endStackPtr == 0 && this.pile[this.endStackPtr] == null; }

    @Override
    public void push(Object obj) throws FullStackException
    {
        if(this.endStackPtr < ConcreteStackArray.STACK_SIZE)
            this.pile[this.endStackPtr++] = obj;
        else
            throw new FullStackException("The stack is full!");
    }

    @Override
    public Object peek() throws EmptyStackException
    {
        Object retour = null;
        if(!this.isEmpty())
            retour = this.pile[this.endStackPtr];
        else
            throw new EmptyStackException();

        return retour;
    }

    @Override
    public Object pop()
    {
        Object retour = null;
        if(!this.isEmpty()) {
            retour = this.pile[this.endStackPtr];
            this.pile[this.endStackPtr--] = null;
        } else
            throw new EmptyStackException();

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
