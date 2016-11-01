package com.abc;

import java.util.Date;

/**
 * Last modified by david fisher on 10/31/2016.
 * Presently this class is not being used - last over from originally implementation
 * Changed interface to give getter for transaction date
 * Class is only needed if transaction date is being used.
 */
public final class Transaction {
    private final double amount;
    private final Date   transactionDate;

    public Transaction(double amount) {
        this.amount          = amount;
        this.transactionDate = DataProvider.INSTANCE.now();
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return transactionDate;
    }
}

