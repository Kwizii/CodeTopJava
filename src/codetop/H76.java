package codetop;

import java.util.HashMap;
import java.util.Map;

class H76 {
    public boolean check(Map<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value > 0) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        int minL = 0, minR = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (r < s.length()) {
            char cr = s.charAt(r);
            if (map.containsKey(cr)) {
                map.compute(cr, (k, v) -> v - 1);
                while (check(map) && l <= r) {
                    if (r - l < minR - minL) {
                        minR = r;
                        minL = l;
                    }
                    map.compute(s.charAt(l++), (k, v) -> v == null ? null : v + 1);
                }
            }
            r++;
        }
        return minR == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }

    public static void main(String[] args) {
        System.out.println(new H76().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}