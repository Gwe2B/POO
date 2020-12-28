package com.exo3;

import java.util.*;

public class RandomSet {
    private static Random r = new Random();
    private static final int MAX = 1000;
    
    private Set<Integer> collection = new TreeSet<Integer>();
    
    public RandomSet(int n) {
        for(int i = 0; i < n; i++) {
            this.collection.add(RandomSet.r.nextInt(RandomSet.MAX));
        }
    }
    
    public Set<Integer> getCollection() { return this.collection; }
}