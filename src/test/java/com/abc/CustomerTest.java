package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test    // Test customer statement generation
    public void testApp() throws Exception {

//      Account checkingAccount = new Account(Account.CHECKING);
//      Account savingsAccount = new Account(Account.SAVINGS);
        Account  checkingAccount = new Account(new CheckingAccountType(), DataProvider.INSTANCE.getId());
        Account  savingsAccount  = new Account(new SavingsAccountType(), DataProvider.INSTANCE.getId());
        Customer henry           = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

//      assertEquals("Statement for Henry\n" +
//              "\n" +
//              "Savings Account\n" +
//              "  deposit $4,000.00\n" +
//              "  withdrawal $200.00\n" +
//              "Total $3,800.00\n" +
//              "\n" +
//              "Checking Account\n" +
//              "  deposit $100.00\n" +
//              "Total $100.00\n" +
//              "\n" +
//              "Total In All Accounts $3,900.00", henry.getStatement());
        assertEquals("Statement for Henry\n" + "\n" + "Checking Account\n" + "  deposit $100.00\n" + "Total $100.00\n"
                     + "\n" + "Savings Account\n" + "  deposit $4,000.00\n" + "  withdrawal $200.00\n"
                     + "Total $3,800.00\n" + "\n" + "Total In All Accounts $3,900.00",
                     henry.getStatement());
    }

    @Test
    public void testOneAccount() throws Exception {

//      Customer oscar = new Customer("Oscar").openAccount(new Account(Account.SAVINGS)
        Customer oscar = new Customer("Oscar").openAccount(new Account(new SavingsAccountType(),
                                                                       DataProvider.INSTANCE.getId()));

        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testThreeAccounts() throws Exception {

//      Customer oscar = new Customer("Oscar")
//              .openAccount(new Account(Account.SAVINGS));
//      oscar.openAccount(new Account(Account.CHECKING));
        Customer oscar = new Customer("Oscar").openAccount(new Account(new SavingsAccountType(),
                                                                       DataProvider.INSTANCE.getId()));

        oscar.openAccount(new Account(new CheckingAccountType(), DataProvider.INSTANCE.getId()));
        oscar.openAccount(new Account(new MaxiSavingsAccountType(), DataProvider.INSTANCE.getId()));
        assertEquals(3, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount() throws Exception {

//      Customer oscar = new Customer("Oscar")
//              .openAccount(new Account(Account.SAVINGS));
//      oscar.openAccount(new Account(Account.CHECKING));
        Customer oscar = new Customer("Oscar").openAccount(new Account(new SavingsAccountType(),
                                                                       DataProvider.INSTANCE.getId()));

        oscar.openAccount(new Account(new CheckingAccountType(), DataProvider.INSTANCE.getId()));
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Test(expected = AccountAlreadyAddedException.class)
    public void testTwoAccountWithSameId() throws Exception {

//      Customer oscar = new Customer("Oscar")
//              .openAccount(new Account(Account.SAVINGS));
//      oscar.openAccount(new Account(Account.CHECKING));
        Long     id    = DataProvider.INSTANCE.getId();
        Customer oscar = new Customer("Oscar").openAccount(new Account(new SavingsAccountType(), id));

        oscar.openAccount(new Account(new CheckingAccountType(), id));
    }
}


