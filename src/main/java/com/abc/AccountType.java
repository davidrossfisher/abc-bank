package com.abc;

/**
 * Last modified by david on 10/31/2016.
 * Abstract class that defines the interface to account type
 * Contains default implementation of interestEarned.
 */
public abstract class AccountType {
    double interestEarned(double totalAmt) {
        return totalAmt * 0.001;
    }

    abstract String getName();
}

