package com.abc;

/**
 * Last modified by david fisher on 10/31/2016.
 * Concrete class that implements the abstract class to account type
 * Uses default implementation of interestEarned.
 */
public class CheckingAccountType extends AccountType {
    @Override
    public String getName() {
        return "Checking Account";
    }
}


