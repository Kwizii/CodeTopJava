package codetop;

public class M53 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(pre, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        new M53().maxSubArray(new int[]{-2, 1});
    }
}
