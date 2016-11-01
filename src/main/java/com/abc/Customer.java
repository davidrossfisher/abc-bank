package com.abc;

//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class is part of the Bank Account of programming exercise last modified by David Fisher on 10-31-2016
 * This class responsibility is have unique name (poor unique id, but only exercise); maintain a collection
 * of associated accounts; and to generate a a customer statement (report of customer transactions by account).
 */
public class Customer {
    private final String       name;
    private final Set<Account> accounts;    // Collection of customers. Implemented as a set because

    // Account should be unique.

    public Customer(String name) {
        this.name     = name;    // Unique id for customer
        this.accounts = (new ConcurrentHashMap<Account, Boolean>()).keySet(true);
    }

    public Customer openAccount(Account account) throws Exception {
        if (!accounts.add(account)) {
            throw new AccountAlreadyAddedException("Account Already Exists");
        }

        return this;
    }

    /**
     * Get total interest earned for all the accounts associated with the customer
     * @return total earned interest
     */
    public double totalInterestEarned() {

//      double total = 0;
//      for (Account a : accounts)
//          total += a.interestEarned();
//      return total;
//      Stream<Account> accountStream = accounts.stream();
        return accounts.stream().map(Account::interestEarned).reduce(0.0, (x, y) -> x + y);
    }

    /**
     * Getter for Name
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of accounts associated with the customer
     * @return number of accounts
     */
    public int getNumberOfAccounts() {
        return accounts.size();
    }

    /**
     * Customer transaction statement by account
     * @return text of statement
     */
    public String getStatement() {
        String statement = "Statement for " + name + "\n";
        double total     = 0.0;

        for (Account a : accounts) {
            statement += "\n" + a.statementForAccount() + "\n";
            total     += a.sumTransactions();
        }

        statement += "\nTotal In All Accounts " + Util.toDollars(total);

        return statement;
    }


    @Override
    public boolean equals(Object cus) {
        return (cus instanceof Customer) && name.equals(((Customer) cus).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

