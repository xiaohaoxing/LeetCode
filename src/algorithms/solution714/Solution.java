package algorithms.solution714;

/**
 * 入参 prices 代表了第 i 天的股票价格
 * fee 代表了交易费用
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int date = 0;
        Status initStatus = new Status(0, 0);
        Status[] status = new Status[]{initStatus};
        while (date < prices.length) {
            Status[] nextStep = new Status[status.length * 2];
            for (int i = 0; i < status.length; i++) {
                if (status[i].buyPrice > 0) {
                    // 买了，则有卖出与不卖出 2 个选择
                    nextStep[i * 2] = new Status(0, status[i].currentProfit + prices[date] - fee);
                    nextStep[i * 2].operation = status[i].operation;
                    nextStep[i * 2].operation += String.format("在第%d天时以 %d 价格卖出，", date, prices[date]);
                    nextStep[i * 2 + 1] = new Status(status[i].buyPrice, status[i].currentProfit);
                    nextStep[i * 2 + 1].operation = status[i].operation;
                } else {
                    // 未买，则有买与不买2 个选择
                    nextStep[i * 2] = new Status(prices[date], status[i].currentProfit - prices[date]);
                    nextStep[i * 2].operation = status[i].operation;
                    nextStep[i * 2].operation += String.format("在第%d天时以 %d 价格买入，", date, prices[date]);
                    nextStep[i * 2 + 1] = new Status(0, status[i].currentProfit);
                    nextStep[i * 2 + 1].operation = status[i].operation;
                }
            }
            status = nextStep;
            date++;
        }
        // 不会有人 1 毛钱赚不到吧？
        int maxProfit = 0;
        Status maxStatus = status[0];
        for (Status s : status) {
            if (s.currentProfit > maxProfit) {
                maxProfit = s.currentProfit;
                maxStatus = s;
            }
        }
        System.out.println(maxStatus.operation);
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        int fee = 3;
        Solution test = new Solution();
        int result = test.maxProfit(prices, fee);
        System.out.println(result);
    }
}

class Status {
    public Status(int buyPrice, int currentProfit) {
        this.buyPrice = buyPrice;
        this.currentProfit = currentProfit;
    }

    /**
     * 如果未买则为 0，否则为买入价格。
     */
    int buyPrice;

    /**
     * 当前已经挣到的钱
     */
    int currentProfit;

    String operation = "";

    @Override
    public String toString() {
        return String.format("Earned %d money, current %s.", currentProfit, buyPrice == 0 ? "没买" : String.format("%d 买的", buyPrice));
    }
}
