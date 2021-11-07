public class RewardPoint {
    int cardNo;
    double rewardPoints;
    String type;

    RewardPoint(int cardNo, int amount) {
        this.cardNo = cardNo;
        this.rewardPoints = 0;
        this.type = "Basic";
    }

    void increaseReward(int amount) {
        while (amount >= 500) {
            this.rewardPoints += 50;
            amount -= 500;
        }
        upgradeType();
    }

    void upgradeType() {
        if (this.rewardPoints >= 200 && this.rewardPoints < 400)
            this.type = "Silver";
        else if (this.rewardPoints >= 400 && this.rewardPoints < 600)
            this.type = "Gold";
        else if (this.rewardPoints >= 600)
            this.type = "Platinum";
    }
}
