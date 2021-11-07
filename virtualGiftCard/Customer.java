/**
 * Customer with unique id and balance
 */
public class Customer {
    static int uniqueCusId = 1000;
    int customerId, bankBalance;

    Customer(int bankBalance) {
        this.customerId = uniqueCusId++;
        this.bankBalance = bankBalance;
    }

    void reduceBalance(int balance) {
        this.bankBalance -= balance;
    }

    void increaseBalance(int balance) {
        this.bankBalance += balance;
    }
}