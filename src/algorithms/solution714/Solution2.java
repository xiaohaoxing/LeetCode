package algorithms.solution714;

public class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        int date = 0;
        Status initStatus = new Status(0, 0);
        Status[] status = new Status[]{initStatus};
        while (date < prices.length) {
            Status[] nextStep = new Status[status.length * 2];
            for (int i = 0; i < status.length; i++) {
                if (status[i].buyPrice > 0) {
                    if (status[i].buyPrice - prices[date] <= fee) {
                        continue;
                    }
                    nextStep[i * 2] = new Status(0, status[i].currentProfit + prices[date] - fee);
                    nextStep[i * 2 + 1] = new Status(status[i].buyPrice, status[i].currentProfit);
                } else {
                    nextStep[i * 2] = new Status(prices[date], status[i].currentProfit - prices[date]);
                    nextStep[i * 2 + 1] = new Status(0, status[i].currentProfit);
                }
            }
            status = nextStep;
            date++;
        }
        int maxProfit = 0;
        Status maxStatus = status[0];
        for (Status s : status) {
            if (s.currentProfit > maxProfit) {
                maxProfit = s.currentProfit;
                maxStatus = s;
            }
        }
        return maxProfit;
    }
}

class NewStatus {
    public NewStatus(int buyPrice, int currentProfit) {
        this.buyPrice = buyPrice;
        this.currentProfit = currentProfit;
    }

    int buyPrice;
    int currentProfit;
}
