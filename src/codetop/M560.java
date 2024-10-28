package codetop;

import java.util.HashMap;
import java.util.Map;

class M560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                ans += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new M560().subarraySum(new int[]{1, 2, 3}, 3);
    }
}