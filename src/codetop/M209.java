package codetop;

class M209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}