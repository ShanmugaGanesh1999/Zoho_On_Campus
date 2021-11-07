import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * VIRTUAL GIFT CARD
 * 
 * Write a program to manage a virtual gift card system by linking with an
 * existing banking system. As part of this, the following operations need to be
 * supported.
 * 
 * ● Account summary ● Creating a Gift Card by using a particular customer's
 * account balance ● Top-up of existing Gift Card with account balance ● Close a
 * Gift Card, which should return balance to the associated account ● Purchase
 * using a Gift Card
 * 
 * Task 1 : Account Summary
 * 
 * Consider a bank system where ● It can have any number of customers ● Each
 * customer is identified by a unique number called Customer Id. ● Each
 * customer's account balance is maintained
 * 
 * Print the account summary as below Customer Id Balance 1 10000 2 20000 3
 * 30000
 * 
 * Task 2 : Create Gift Card
 * 
 * Each gift card is identified by a unique card number called Card No and a PIN
 * is also set (like our ATM card PIN) to protect misuse of it during every
 * purchase. Each customer can create as many gift cards as possible and money
 * for the same is debited from the customer's bank account
 * 
 * For e.g. if a customer-1 has 10000 in the bank account and if two cards are
 * created with Rs2500 each, then bank balance will now be 5000. You may also
 * maintain a status which keeps track of whether the card is active / closed.
 * 
 * Gift Card Summary
 * 
 * Card No Cust Id PIN Gift Card Balance Status 1 1 1111 2500 Active 2 1 2222
 * 2500 Active 3 2 3333 5000 Active 4 2 1234 0 Closed
 * 
 * After creating the above set of gift cards, if you print account summary, it
 * will be like this
 * 
 * Customer Id Balance 1 5000 2 15000 3 30000
 * 
 * Task 3 : Top-Up Gift Card
 * 
 * Each gift card can be topped-up at any moment. Similar to the purchase
 * option, amount chosen for top-up will be debited from bank account and
 * credited into the gift card account. Each top-up process will require input
 * like Card No and top-up amount. Support this operation and verify by printing
 * Account Summary and the Gift Card Summary
 * 
 * Task 4 : Close Gift Card
 * 
 * If a customer decides to close a gift card, the remaining amount in the gift
 * card should be credited back to the original account. Close gift card option
 * should accept Card No and the PIN. Only if the PIN matches, this operation
 * should be allowed. Once this operation is performed, the card status should
 * be closed, verify the same by printing Account Summary and Gift Card Summary.
 * 
 * Task 5 : Purchase Item
 * 
 * You may use any gift card as part of any purchase process. During each
 * purchase you are required to give card number, PIN and the amount required
 * for purchase. Keep a record of all the transactions and print a summary as
 * and when required
 * 
 * Transaction Summary
 * 
 * Txn No Card No Amount 1 2 1000 2 2 1000 3 3 2000
 * 
 * At the end of this operation print Account Summary and Gift Card Summary to
 * verify results.
 * 
 * Task 6 : Block / Unblock Card
 * 
 * Support operations to block the card temporarily. If done so, those cards
 * can't be used in purchases or top-up operations. But it can be closed. If a
 * blocked card is closed, then the status should be closed.
 * 
 * Blocked cards can anytime unblocked. Gift card status column should reflect
 * if the card is blocked or not in addition to the existing two status like
 * active or closed.
 * 
 * Task 7 : Reward Points (Advance Question)
 * 
 * Store Reward Points for each Gift Card. For each purchase of Rs.500, add
 * reward points of 50 to the gift card. Print the Reward Points also along with
 * the Gift card summary.
 * 
 * Task 8 : Gift Card Type (Advance Question)
 * 
 * Let the Gift card type be Silver, Gold & Platinum. On the accumulation of 200
 * points, the card automatically changes to the next type.
 * 
 * For example, a Silver Gift card will change to the Gold Gift card on the
 * accumulation of 200 points. Once converted, the reward point count will be
 * reset to Zero for the Gold card. Print the Gift card summary along with the
 * Card type and reward points count.
 * 
 */

public class VirtualGiftCard {

    static Map<Integer, Customer> customerArray = new HashMap<>();
    static Map<Integer, GiftCard> giftCardArray = new HashMap<>();
    static Map<Integer, GiftCard> blockedCardsArray = new HashMap<>();
    static Map<Integer, Transaction> transactionArray = new HashMap<>();
    static Map<Integer, RewardPoint> rewardsArray = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            boolean loop = true;
            while (loop) {
                System.out.print(
                        "Please enter your choice,\nAccount Summary - 1\nCreate Gift Card - 2\nTop-Up Gift Card - 3\nClose Gift Card - 4\nPurchase Item - 5\nBlock / Unblock Card - 6\nView Reward Points - 7\nGift Card Type - 8\nQuit - 0\n-> ");
                int choice = scanner.nextInt();
                switch (choice) {
                case 0: {
                    loop = false;
                    break;
                }
                case 1: {
                    System.out.print("Create a bank account - 1\nTo view all account - 2\n-> ");
                    int innerChoice = scanner.nextInt();
                    if (innerChoice == 1) {
                        System.out.print("Enter the amount with which you want to open your bank account\n-> ");
                        int balance = scanner.nextInt();
                        Customer newCustomer = new Customer(balance);
                        customerArray.put(newCustomer.customerId, newCustomer);
                        System.out.println(".....Your account created successfully.....");
                    } else if (innerChoice == 2) {
                        accountSummary();
                    } else
                        System.out.println(".....Not a valid option.....");
                    break;
                }
                case 2: {
                    System.out.print("Create a gift card - 1\nTo view all gift card's - 2\n-> ");
                    int innerChoice = scanner.nextInt();
                    if (innerChoice == 1)
                        createGiftCard(scanner);
                    else if (innerChoice == 2)
                        giftCardSummary();
                    else
                        System.out.println(".....Not a valid option.....");
                    break;
                }
                case 3: {
                    topUpGiftCard(scanner);
                    break;
                }
                case 4: {
                    closeGiftCard(scanner);
                    break;
                }
                case 5: {
                    System.out.print("Create a transaction - 1\nTo view all transaction's - 2\n-> ");
                    int innerChoice = scanner.nextInt();
                    if (innerChoice == 1)
                        purchaseItem(scanner);
                    else if (innerChoice == 2)
                        transactionSummary();
                    else
                        System.out.println(".....Not a valid option.....");
                    break;
                }
                case 6: {
                    System.out.print("Block/Unblock a gift card - 1\nTo view all blocked gift card's - 2\n-> ");
                    int innerChoice = scanner.nextInt();
                    if (innerChoice == 1)
                        blockOrUnblockCard(scanner);
                    else if (innerChoice == 2)
                        blockedCardSummary();
                    else
                        System.out.println(".....Not a valid option.....");
                    break;
                }
                case 7: {
                    rewardPoint();
                    break;
                }
                case 8: {
                    giftCardType();
                    break;
                }
                default:
                    break;
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        } finally {
            scanner.close();
        }
    }

    private static void giftCardType() {
        rewardPoint();
    }

    private static void rewardPoint() {
        if (rewardsArray.size() == 0) {
            System.out.println("\n.....No reward points to view.....\n");
        } else {
            System.out.println("CardNo\tReward Points\t");
            for (RewardPoint reward : rewardsArray.values()) {
                System.out.println(reward.cardNo + "\t" + reward.rewardPoints + "\t" + reward.type);
            }
        }
    }

    private static void blockOrUnblockCard(Scanner scanner) {
        while (true) {
            System.out.print("\nTo Block a card - 1\nTo Unblock a card - 2\nTo quit this operation - 3\n-> ");
            int innerChoice = scanner.nextInt();
            if (innerChoice == 1) {
                giftCardSummary();
                System.out.print("\nChoose a card to block\n-> ");
                int blockNo = scanner.nextInt();

                GiftCard card = giftCardArray.get(blockNo);
                if (card != null) {
                    System.out.print("\nAre you really want to block this gift card?\nYES - 1\nNO - 2\n-> ");
                    int confirmation = scanner.nextInt();
                    if (confirmation == 1) {
                        blockedCardsArray.put(card.cardNo, card);
                        System.out.println(".....The gift card was temporarily blocked.....");
                        blockedCardSummary();
                    }
                } else {
                    System.out.println("Sorry no gift card with " + blockNo + " found\nENTER A VALID GIFT CARD NUMBER");
                    giftCardSummary();
                    // try again
                    System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                    int again = scanner.nextInt();
                    if (again != 1)
                        break;
                }
            } else if (innerChoice == 2) {
                if (blockedCardsArray.size() == 0) {
                    System.out.println(".....No cards blocked.....");
                } else {
                    blockedCardSummary();
                    System.out.print("\nChoose a card from blocked list\n-> ");
                    int unblockNo = scanner.nextInt();

                    GiftCard blockedCard = blockedCardsArray.get(unblockNo);
                    if (blockedCard != null) {
                        blockedCardsArray.remove(blockedCard.cardNo);
                        System.out.println(".....The card was successfully unblocked.....");
                        blockedCardSummary();
                        break;
                    } else {
                        System.out.println(
                                "Sorry no gift card with " + unblockNo + " found\nENTER A VALID GIFT CARD NUMBER");
                        giftCardSummary();
                        // try again
                        System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                        int again = scanner.nextInt();
                        if (again != 1)
                            break;
                    }
                }
            } else
                break;
        }
    }

    private static void purchaseItem(Scanner scanner) {
        while (true) {
            System.out.print("\nPurchasing item's with gift card");
            System.out.print("\nEnter your gift card number -> ");
            int cardNumber = scanner.nextInt();

            GiftCard card = giftCardArray.get(cardNumber);
            if (card != null) {
                if (card.status != "Close") {
                    GiftCard isBlocked = blockedCardsArray.get(cardNumber);
                    if (isBlocked == null) {
                        System.out.print("\nEnter the pin for your gift card -> ");
                        int localPin = scanner.nextInt();
                        // System.out.print("\n.....You balance in bank account is " + cus.bankBalance +
                        // ".....\n");
                        if (card.pin == localPin) {
                            System.out.print("\nPlease enter the amount you want to purchase\n-> ");
                            int amt = scanner.nextInt();
                            if (amt <= card.cardBalance) {
                                card.reduceCardBalance(amt);
                                Transaction newTransaction = new Transaction(card.cardNo, amt);
                                transactionArray.put(newTransaction.transactionId, newTransaction);
                                if (rewardsArray.get(card.cardNo) == null) {
                                    RewardPoint addRewardPoints = new RewardPoint(card.cardNo, amt);
                                    rewardsArray.put(card.cardNo, addRewardPoints);
                                }
                                rewardsArray.get(card.cardNo).increaseReward(amt);
                                System.out.println(".....Your transaction was successfully.....");
                                transactionSummary();
                                rewardPoint();
                                giftCardSummary();
                                accountSummary();
                                break;
                            } else {
                                System.out.println("Sorry the gift card has insufficient balance [to be exact:"
                                        + card.cardBalance + "]\nENTER A VALID AMOUNT");
                                // try again
                                System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                                int again = scanner.nextInt();
                                if (again != 1)
                                    break;
                            }
                        } else {
                            System.out.println("Sorry transaction failed\nENTER A VALID PIN");
                            // try again
                            System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                            int again = scanner.nextInt();
                            if (again != 1)
                                break;
                        }
                    } else {
                        System.out.println(
                                "Sorry the gift card was temporarily blocked\nENTER A VALID GIFT CARD (or) TRY TO UNBLOCK THE GIFT CARD");
                        // try again
                        System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                        int again = scanner.nextInt();
                        if (again != 1)
                            break;
                    }
                } else {
                    System.out.println("Sorry the gift card was closed\nENTER A ACTIVE GIFT CARD");
                    // try again
                    System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                    int again = scanner.nextInt();
                    if (again != 1)
                        break;
                }
            } else {
                System.out.println("Sorry no gift card with " + cardNumber + " found\nENTER A VALID GIFT CARD NUMBER");
                giftCardSummary();
                // try again
                System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                int again = scanner.nextInt();
                if (again != 1)
                    break;
            }
        }
    }

    private static void closeGiftCard(Scanner scanner) {
        while (true) {
            System.out.print("\nClosing gift card");
            System.out.print("\nEnter your gift card number -> ");
            int cardNumber = scanner.nextInt();

            GiftCard card = giftCardArray.get(cardNumber);
            if (card != null) {
                System.out.print("\nEnter the pin for your gift card -> ");
                int localPin = scanner.nextInt();
                // System.out.print("\n.....You balance in bank account is " + cus.bankBalance +
                // ".....\n");
                if (card.pin == localPin) {
                    System.out.print("\nAre you really want to close the gift card?\nYES - 1\nNO - 2\n-> ");
                    int confirmation = scanner.nextInt();
                    if (confirmation == 1) {
                        Customer cus = customerArray.get(card.customerId);
                        int addBal = card.cardBalance;
                        cus.increaseBalance(addBal);
                        card.closeGiftCardCard();
                        System.out.println(".....Your gift card was closed successfully.....");
                        giftCardSummary();
                        accountSummary();
                    }
                    break;
                } else {
                    System.out.println("Sorry transaction failed\nENTER A VALID PIN");
                    // try again
                    System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                    int again = scanner.nextInt();
                    if (again != 1)
                        break;
                }
            } else {
                System.out.println("Sorry no gift card with " + cardNumber + " found\nENTER A VALID GIFT CARD NUMBER");
                giftCardSummary();
                // try again
                System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                int again = scanner.nextInt();
                if (again != 1)
                    break;
            }
        }
    }

    private static void topUpGiftCard(Scanner scanner) {
        while (true) {
            System.out.print("\nTop up gift card");
            System.out.print("\nEnter your gift card number -> ");
            int cardNumber = scanner.nextInt();

            GiftCard card = giftCardArray.get(cardNumber);
            if (card != null) {
                if (card.status != "Close") {
                    GiftCard isBlocked = blockedCardsArray.get(cardNumber);
                    if (isBlocked == null) {
                        Customer cus = customerArray.get(card.customerId);
                        System.out.print("\nEnter the amount to top up your gift card -> ");
                        int amt = scanner.nextInt();
                        // System.out.print("\n.....You balance in bank account is " + cus.bankBalance +
                        // ".....\n");
                        if (cus.bankBalance >= amt) {
                            cus.reduceBalance(amt);
                            card.increaseCardBalance(amt);
                            System.out.println(".....Your gift card top up was successful.....");
                            giftCardSummary();
                            accountSummary();
                            break;
                        } else {
                            System.out.println("Sorry the customer has insufficient balance [to be exact:"
                                    + cus.bankBalance + "]\nENTER A VALID AMOUNT");
                            // try again
                            System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                            int again = scanner.nextInt();
                            if (again != 1)
                                break;
                        }
                    } else {
                        System.out.println(
                                "Sorry the gift card was temporarily blocked\nENTER A VALID GIFT CARD (or) TRY TO UNBLOCK THE GIFT CARD");
                        // try again
                        System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                        int again = scanner.nextInt();
                        if (again != 1)
                            break;
                    }
                } else {
                    System.out.println("Sorry the gift card was closed\nENTER A ACTIVE GIFT CARD");
                    // try again
                    System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                    int again = scanner.nextInt();
                    if (again != 1)
                        break;
                }
            } else {
                System.out.println("Sorry no gift card with " + cardNumber + " found\nENTER A VALID GIFT CARD NUMBER");
                giftCardSummary();
                // try again
                System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                int again = scanner.nextInt();
                if (again != 1)
                    break;
            }
        }
    }

    private static void createGiftCard(Scanner scanner) {
        while (true) {
            System.out.print("\nCreating a gift card");
            System.out.print("\nEnter your bank customer id -> ");
            int cusId = scanner.nextInt();

            Customer cus = customerArray.get(cusId);
            if (cus != null) {
                System.out.print("\nEnter your gift card's pin(4 digit) -> ");
                int localPin = scanner.nextInt();
                // System.out.print("\n.....You balance in bank account is " + cus.bankBalance +
                // ".....\n");
                System.out.print("\nEnter your gift card amount/balance -> ");
                int bal = scanner.nextInt();
                if (cus.bankBalance >= bal) {
                    cus.reduceBalance(bal);
                    GiftCard newGiftCard = new GiftCard(cusId, localPin, bal);
                    giftCardArray.put(newGiftCard.cardNo, newGiftCard);
                    System.out.println(".....Your gift card was created successfully.....");
                    giftCardSummary();
                    accountSummary();
                    break;
                } else {
                    System.out.println("Sorry the customer has insufficient balance [to be exact:" + cus.bankBalance
                            + "]\nENTER A VALID AMOUNT");
                    // try again
                    System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                    int again = scanner.nextInt();
                    if (again != 1)
                        break;
                }
            } else {
                System.out.println("Sorry no customer with " + cusId + " found\nENTER A VALID CUSTOMER ID");
                accountSummary();
                // try again
                System.out.print("Want to try again?\nYES - 1\tNO - 2\n-> ");
                int again = scanner.nextInt();
                if (again != 1)
                    break;
            }
        }
    }

    private static void transactionSummary() {
        if (transactionArray.size() == 0) {
            System.out.println("\n.....No transaction happened.....\n");
        } else {
            System.out.println("TxnNo\tCardNo\tAmount");
            for (Transaction txn : transactionArray.values()) {
                System.out.println(txn.transactionId + "\t" + txn.cardNo + "\t" + txn.transactionAmount);
            }
        }
    }

    private static void blockedCardSummary() {
        if (blockedCardsArray.size() == 0) {
            System.out.println("\n.....No gift card is blocked.....\n");
        } else {
            System.out.println("CardNo\tCustomerId\tPin\tGift Amount\tStatus");
            for (GiftCard bCard : blockedCardsArray.values()) {
                System.out.println(bCard.cardNo + "\t" + bCard.customerId + "\t\t" + bCard.pin + "\t"
                        + bCard.cardBalance + "\t\t" + bCard.status);
            }
        }
    }

    private static void giftCardSummary() {
        if (giftCardArray.size() == 0) {
            System.out.println("\n.....No gift card generated.....\n");
        } else {
            System.out.println("CardNo\tCustomerId\tPin\tGift Amount\tStatus");
            for (GiftCard card : giftCardArray.values()) {
                System.out.println(card.cardNo + "\t" + card.customerId + "\t\t" + card.pin + "\t" + card.cardBalance
                        + "\t\t" + card.status);
            }
        }
    }

    private static void accountSummary() {
        if (customerArray.size() == 0) {
            System.out.println("\n.....No customers registered.....\n");
        } else {
            System.out.println("CustomerId\tBalance");
            for (Customer cus : customerArray.values()) {
                System.out.println(cus.customerId + "\t\t" + cus.bankBalance);
            }
        }
    }
}