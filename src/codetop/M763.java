package codetop;

import java.util.ArrayList;
import java.util.List;

public class M763 {
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[27];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if (i == right) {
                ans.add(right - left + 1);
                left = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new M763().partitionLabels("caedbdedda");
    }
}
