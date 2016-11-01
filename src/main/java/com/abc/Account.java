package com.abc;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Class is part of the Bank Account of programming exercise last modified by David Fisher on 10-31-2016
 * This class responsibility is to maintain a list of transaction associated with the account and
 * to generate the account statement which is the account transaction report.
 */
public class Account {

    private final Long id;
    private final AccountType accountType;
    private final List<Double> transactions; //I changed the list from transactions object to double because, nothing
    //used the time stamp, and the only spec was the report generated and the unit tests. I did fix interface the
    //the transaction object interface to return the timestamp if the timestamp of the transaction is required.


    public Account(AccountType accountType, long accountId) {
        this.accountType = accountType;
        this.id = accountId;
        this.transactions = new CopyOnWriteArrayList<>();
    }

    /**
     * adds transaction to the transaction list - deposit is added as a positive amount
     * @param amount deposit amount most be positive and is saved as a positive value
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(amount);
        }
    }

    /**
     * adds transaction to the transaction list - deposit is added as a negative of the amount given
     * @param amount withdrawal amount is positive but is saved as a negative value
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(-amount);
        }
    }

    /**
     * sum the interest earned for each transaction using the calculation of the account type.
     * @return interest earned
     */
    public double interestEarned() {
        double amount = sumTransactions();
        return accountType.interestEarned(amount);
    }

    /**
     * Sums transaction amounts
     * @return sum of transactions
     */
    public double sumTransactions() {
        return transactions.stream().reduce(0.0, (x, y) -> x + y);
    }

    /**
     * Account transactions statement
     * @return text of withdrawel and deposits
     */
    public String statementForAccount() {
        String s = accountType.getName() + "\n";

        //Now total up all the transactions
        double total = 0.0;
        for (Double t : transactions) {
            s += "  " + (t < 0 ? "withdrawal" : "deposit") + " " + Util.toDollars(t) + "\n";
            total += t;
        }
        s += "Total " + Util.toDollars(total);
        return s;
    }

    /**
     * Gets name of account type associated with account
     * @return a
     */
    public String getAccountType() {
        return accountType.getName();
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object acc) {
        return (acc instanceof Account) && id.equals(((Account) acc).id);
    }
}
