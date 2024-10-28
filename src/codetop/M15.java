package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) continue;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[left + 1] == nums[left]) left++;
                    while (right > left && nums[right - 1] == nums[right]) right--;
                    right--;
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
