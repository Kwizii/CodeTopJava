package codetop;

import java.util.Arrays;

public class M698 {

    boolean[] dp;

    public boolean partition(int[] nums, int m, int sum, int target) {
        if (m == 0) {
            return true;
        }
        if (!dp[m]) {
            return false;
        }
        dp[m] = false;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }
            if (((m >> i) & 1) == 1) {
                if (partition(nums, m ^ (1 << i), (sum + nums[i]) % target, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int per = sum / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }
        dp = new boolean[1 << n];
        Arrays.fill(dp, true);
        return partition(nums, (1 << n) - 1, 0, per);
    }

    public static void main(String[] args) {
        System.out.println(new M698().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
