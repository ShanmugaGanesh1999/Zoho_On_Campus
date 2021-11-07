/**
 * GiftCard
 */

public class GiftCard {
    static int uniqueCardId = 4000;
    int cardNo, customerId, pin, cardBalance;
    String status;

    GiftCard(int customerId, int pin, int cardBalance) {
        this.cardNo = uniqueCardId++;
        this.customerId = customerId;
        this.pin = pin;
        this.cardBalance = cardBalance;
        this.status = "Active";
    }

    void increaseCardBalance(int balance) {
        this.cardBalance += balance;
    }

    void reduceCardBalance(int balance) {
        this.cardBalance -= balance;
    }

    void closeGiftCardCard() {
        this.status = "Close";
    }
}