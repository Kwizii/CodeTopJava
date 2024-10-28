package codetop;

public class M3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] mask = new boolean[128];
        int l = 0;
        int len = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (mask[c]) {
                char p = s.charAt(l++);
                mask[p] = false;
            }
            mask[c] = true;
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}
