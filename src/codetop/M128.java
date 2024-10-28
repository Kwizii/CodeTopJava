package codetop;

import java.util.Set;
import java.util.TreeSet;

class M128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new TreeSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int ans = 0;
        for (int num : s) {
            if (!s.contains(num - 1)) {
                int cur = num;
                int len = 1;
                while (s.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new M128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
}