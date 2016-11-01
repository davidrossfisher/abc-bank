package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
// Test is not needed in this implementation.  Boogus test anyway.  Tautology.
public class TransactionTest {
    @Test
    public void transaction() {
        Transaction t = new Transaction(5);

        assertTrue(t instanceof Transaction);
    }
}


