package com.exo2;

import java.util.*;
import java.io.*;

// TODO: Complete the class to find the anagrams & store it to a data structure

public class Anagramme {
    private int limite;
    private Map<Integer, ArrayList<String>> anagrammes = new TreeMap<Integer, ArrayList<String>>();

    public Anagramme(String filename, int limite) {
        this.limite = limite;
        this.readFile(filename);
    }

    private void readFile(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));
            int index = 0;

            do {
                boolean expand = true;
                String buf = scan.nextLine();
                int i = 0;

                while(i < this.anagrammes.size() && expand) {
                    if(Anagramme.isAnagramme(this.anagrammes.get(i).get(0), buf)) {
                        this.anagrammes.get(i).add(buf);
                        expand = false;
                    }
                    i++;
                }

                if(expand) {
                    ArrayList<String> arrBuf = new ArrayList<>();
                    arrBuf.add(buf);
                    this.anagrammes.put(index, arrBuf);
                    index++;
                }
            } while(scan.hasNext());
        } catch(FileNotFoundException e) {
            System.err.println("File Not Found");
        }

        this.cleanAnagrammes();
    }

    private void cleanAnagrammes() {
        int initialSize = this.anagrammes.size();

        for (int i = 0; i < initialSize; i++) {

            if(this.anagrammes.get(i).size() < this.limite){
                this.anagrammes.remove(i, this.anagrammes.get(i));
            }
        }
    }

    public Map<Integer, ArrayList<String>> getAnagrammes() {
        return this.anagrammes;
    }

    public static boolean isAnagramme(String w1, String w2) {
        char[] word1 = w1.replaceAll("[\s]", "").toCharArray();
        char[] word2 = w2.replaceAll("[\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }
}
