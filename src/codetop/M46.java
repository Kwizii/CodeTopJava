package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class M46 {
    List<List<Integer>> ans = new ArrayList<>();

    public void backtrack(int n, List<Integer> arr, int first) {
        if (first == n) {
            ans.add(new ArrayList<>(arr));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(arr, i, first);
            backtrack(n, arr, first + 1);
            Collections.swap(arr, i, first);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums.length, Arrays.stream(nums).boxed().collect(Collectors.toList()), 0);
        return ans;
    }

    public static void main(String[] args) {
        new M46().permute(new int[]{1, 2, 3});
    }
}
