package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

//  @Test
//  public void addCustomer() throws Exception {
//
//  }
//
//  @Test
//  public void totalInterestPaid() throws Exception {
//
//  }
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void checkingAccount() throws Exception {
        Bank bank = new Bank();

//      Account checkingAccount = new Account(Account.CHECKING);
        Account  checkingAccount = new Account(new CheckingAccountType(), DataProvider.INSTANCE.getId());
        Customer bill            = new Customer("Bill").openAccount(checkingAccount);

        bank.addCustomer(bill);
        checkingAccount.deposit(100.0);
        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void customerSummary() throws Exception {
        Bank     bank = new Bank();
        Customer john = new Customer("John");

        john.openAccount(new Account(new CheckingAccountType(), DataProvider.INSTANCE.getId()));

//      john.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(john);
        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void maxi_savings_account() throws Exception {
        Bank bank = new Bank();

//      Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        Account maxiSavingsAccount = new Account(new MaxiSavingsAccountType(), DataProvider.INSTANCE.getId());

        bank.addCustomer(new Customer("Bill").openAccount(maxiSavingsAccount));
        maxiSavingsAccount.deposit(3000.0);
        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test(expected = CustomerAlreadyAddedException.class)
    public void same_customer() throws Exception {
        Bank    bank               = new Bank();
        Account savingAccount      = new Account(new SavingsAccountType(), DataProvider.INSTANCE.getId());
        Account maxiSavingsAccount = new Account(new MaxiSavingsAccountType(), DataProvider.INSTANCE.getId());

        bank.addCustomer(new Customer("Bill").openAccount(savingAccount));
        bank.addCustomer(new Customer("Bill").openAccount(maxiSavingsAccount));
        maxiSavingsAccount.deposit(3000.0);
    }

    @Test
    public void savings_account() throws Exception {
        Bank bank = new Bank();

//      Account checkingAccount = new Account(Account.SAVINGS);
        Account savingAccount = new Account(new SavingsAccountType(), DataProvider.INSTANCE.getId());

        bank.addCustomer(new Customer("Bill").openAccount(savingAccount));
        savingAccount.deposit(1500.0);
        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }
}


