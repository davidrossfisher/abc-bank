package com.abc;

/**
 * Last modified by david fisher on 10/31/2016.
 * Concrete class that implements the abstract class to account type
 * Overrides default implementation of interestEarned.
 */
public class SavingsAccountType extends AccountType {
    @Override
    double interestEarned(double totalAmt) {
        double interest = 0;

        if (totalAmt <= 0) return 0;

        if (totalAmt <= 1000) {
            interest = totalAmt * 0.001;
        } else {
            interest = 1 + (totalAmt - 1000) * 0.002;
        }

        return interest;
    }

    @Override
    public String getName() {
        return "Savings Account";
    }
}
