package com.exo4;

import java.util.Comparator;

public class WordSort {
    public static final Comparator<String> LEXICAL_COMPARATOR = 
        new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                int index = 0;

                char[] word1 = o1.toCharArray();
                char[] word2 = o2.toCharArray();

                while(index < word1.length && index < word2.length && result == 0)
                {
                    if(word1[index] < word2[index])
                        result = -1;
                    else if(word1[index] > word2[index])
                        result = 1;

                    index++;
                }

                if (result == 0) {
                    if(word1.length < word2.length)
                        result = -1;
                    else if(word1.length > word2.length)
                        result = 1;
                }

                return result;
            }
        };

    public static final Comparator<String> REVERSED_LEXICAL_COMPARATOR = 
        new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                int index = 0;

                char[] word1 = o1.toCharArray();
                char[] word2 = o2.toCharArray();

                while(index < word1.length && index < word2.length && result == 0)
                {
                    if(word1[index] < word2[index])
                        result = 1;
                    else if(word1[index] > word2[index])
                        result = -1;

                    index++;
                }

                if (result == 0) {
                    if(word1.length < word2.length)
                        result = 1;
                    else if(word1.length > word2.length)
                        result = -1;
                }

                return result;
            }
        };

    public static final Comparator<String> MILITARY_COMPARATOR = 
        new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                int index = 0;

                char[] word1 = o1.toCharArray();
                char[] word2 = o2.toCharArray();

                if(word1.length < word2.length)
                    result = -1;
                else if(word1.length > word2.length)
                    result = 1;

                while(index < word1.length && result == 0)
                {
                    if(word1[index] < word2[index])
                        result = -1;
                    else if(word1[index] > word2[index])
                        result = 1;

                    index++;
                }

                return result;
            }
        };
}
