package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class M39 {
    List<List<Integer>> ans = new ArrayList<>();

    List<Integer> cur = new ArrayList<>();

    public void backtrack(int[] nums, int idx, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(cur));
        }
        for (int i = idx; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }
            cur.add(nums[i]);
            backtrack(nums, i, sum + nums[i], target);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target);
        return ans;
    }
}