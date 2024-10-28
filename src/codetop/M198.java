package codetop;

class M198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int p1 = nums[0], p2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int tmp = Math.max(p1 + nums[i], p2);
            p1 = p2;
            p2 = tmp;
        }
        return p2;
    }
}