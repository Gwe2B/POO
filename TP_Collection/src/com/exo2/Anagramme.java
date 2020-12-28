package com.exo2;

import java.util.*;
import java.io.*;

// TODO: Complete the class to find the anagrams & store it to a data structure

public class Anagramme {
    private int limite;

    public Anagramme(String filename, int limite) {
        this.limite = limite;
        this.readFile(filename);
    }

    private void readFile(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));

            while(scan.hasNext())
                System.out.print(scan.next() + " ");
        } catch(FileNotFoundException e) {
            System.err.println("File Not Found");
        }
    }

    public static boolean isAnagramme(String w1, String w2) {
        char[] word1 = w1.replaceAll("[\s]", "").toCharArray();
        char[] word2 = w2.replaceAll("[\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }
}
