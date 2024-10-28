package codetop;

class M300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new M300().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
    }
}