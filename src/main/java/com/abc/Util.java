package com.abc;

import static java.lang.Math.abs;

/**
 * Last update by david fisher on 10/31/2016.
 */
public class Util {

    // Make sure correct plural of word is created based on the number passed in:
    // If number passed in is 1 just return the word otherwise add an 's' at the end
    public static String formatSingleOrPlural(int number, String word) {
        return number + " " + ((number == 1)
                               ? word
                               : word + "s");
    }

    public static String toDollars(double d) {
        return String.format("$%,.2f", abs(d));
    }
}

