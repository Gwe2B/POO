package utils.exo2;

import java.util.Random;

public class Hasard {
    private static Random r = new Random();

    public static <T> T choice(T[] arr) {
        return arr[Hasard.r.nextInt(arr.length)];
    }
}
