package codetop;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class M78 {
    List<List<Integer>> ans = new ArrayList<>();

    Deque<Integer> cur = new LinkedList<>();

    public void backtrack(int[] nums, int idx, int len) {
        if (cur.size() == len) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            cur.push(nums[i]);
            backtrack(nums, i + 1, len);
            cur.pop();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            backtrack(nums, 0, i + 1);
        }
        return ans;
    }
}