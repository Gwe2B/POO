package com.exo3;

import java.util.*;

public class RandomList {
    private static Random r = new Random();
    private static final int MAX = 1000;

    private List<Integer> collection = new ArrayList<Integer>();

    public RandomList(int n) {
        for(int i = 0; i < n; i++) {
            this.collection.add(RandomList.r.nextInt(RandomList.MAX));
        }

        Collections.sort(this.collection);
    }

    public List<Integer> getCollection() { return this.collection; }
}
