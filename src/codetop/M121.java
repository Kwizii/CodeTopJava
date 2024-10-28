package codetop;

public class M121 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}
