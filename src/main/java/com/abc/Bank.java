package com.abc;

//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class is part of the Bank Account of programming exercise last modified by David Fisher on 10-31-2016
 * This class responsibility is to maintain a list of bank customers and to generate customer aggregation reports.
 */
public class Bank {
    private final Set<Customer> customers;    // Collection of customers. Implemented as a set because

    // Customers should be unique.

    public Bank() {
        customers = (new ConcurrentHashMap<Customer, Boolean>()).keySet(true);
    }

    /**
     * Adds a customer to the bank - if customer already exists (name defines identity) an exception is thrown
     * @param customer bank customer
     * @throws Exception when customer has previously been added
     */
    public void addCustomer(Customer customer) throws Exception {
        if (!customers.add(customer)) {
            throw new CustomerAlreadyAddedException("Customer " + customer.getName() + " Already Exists");
        }
    }

    /**
     * Customer summary report
     * @return text of report
     */
    public String customerSummary() {

//      String summary = "Customer Summary";
//      for (Customer c : customers)
//          summary += "\n - " + c.getName() + " (" + Util.formatSingleOrPlural(c.getNumberOfAccounts(), "account") + ")";
//      return summary;
        return "Customer Summary"
               + customers.stream().map(c -> "\n - " + c.getName() + " ("
                                             + Util.formatSingleOrPlural(c.getNumberOfAccounts(),
                                                                         "account") + ")").reduce("",
                                                                                                  (x, y) -> x + y);
    }

    /**
     * Calculates total interest paid for all customers
     * @return total interest
     */
    public double totalInterestPaid() {

//      double total = 0;
//      for(Customer c: customers)
//          total += c.totalInterestEarned();
//      return total;
        return customers.stream().map(Customer::totalInterestEarned).reduce(0.0, (x, y) -> x + y);
    }

    /*
     * getFirstCustomer was removed because it is not being used by application code or tests; the present implementation
     * returns the "first customer", which is the first customer added; and I do not understand the use case for this method.
     * The simple implementation uses the list (original implementation).  I could have used concurrentskiplistset ordered
     * an ordinality attribute in customer if it is a necessary used case.
     */

//  public String getFirstCustomer() {
//      try {
//          customers = null;
//          return customers.get(0).getName();
//      } catch (Exception e){
//          e.printStackTrace();
//          return "Error";
//      }
//  }
}

