package com;

public class MonTableau implements EstComparable {

/* --------------------------- instance attribute --------------------------- */
    private int[] array;

    /**
     * Constcuctor
     * @param tab The array of values
     */
    public MonTableau(int[] tab)
    { this.array = tab.clone(); }

/* --------------------- EstComparable inherited methods -------------------- */
    @Override
    public int compareA(Object obj) {
        int result;
        int bufArray = 0;
        int bufObj = 0;

        for(int el : this.array)
            bufArray += el;
            
        if(obj == null)
            throw new NullPointerException();
        else if(obj instanceof MonTableau) {
            for(int el : ((MonTableau)obj).array)
                bufObj += el;
        } else if(obj instanceof int[]) {
            for(int el : (int[])obj)
                bufObj += el;
        } else
            throw new IllegalArgumentException();

        if(bufArray < bufObj)
            result = -1;
        else if(bufArray == bufObj)
            result = 0;
        else
            result = 1;

        return result;
    }
    
}
