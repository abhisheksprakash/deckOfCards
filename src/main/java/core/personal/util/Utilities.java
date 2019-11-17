package core.personal.util;

import java.util.concurrent.ThreadLocalRandom;

public class Utilities {
    public static int getRandomNumber(int min, int max) {
        // can use the math class for random. this is thread safe.
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
