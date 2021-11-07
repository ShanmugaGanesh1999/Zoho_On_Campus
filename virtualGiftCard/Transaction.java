public class Transaction {
    static int uniqueTransactionId = 8000;
    int cardNo, transactionAmount, transactionId;

    Transaction(int cardNo, int amount) {
        this.transactionId = uniqueTransactionId++;
        this.cardNo = cardNo;
        this.transactionAmount = amount;
    }
}
