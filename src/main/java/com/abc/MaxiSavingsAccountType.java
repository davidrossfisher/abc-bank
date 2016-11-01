package com.abc;

/**
 * Last modified by david fisher on 10/31/2016.
 * Concrete class that implements the abstract class to account type
 * Overrides default implementation of interestEarned.
 */
public class MaxiSavingsAccountType extends AccountType {
    @Override
    public double interestEarned(double totalAmt) {
        double interest = 0;

        if (totalAmt <= 0) return 0;
        if (totalAmt <= 1000) {
            interest = totalAmt * 0.02;
        } else if (totalAmt <= 2000) {
            interest = 20 + (totalAmt - 1000) * 0.05;
        } else {
            interest = 70 + (totalAmt - 2000) * 0.1;
        }

        return interest;
    }

    @Override
    public String getName() {
        return "Maxi Savings Account";
    }
}

