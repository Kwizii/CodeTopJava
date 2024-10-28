package codetop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class M139 {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> wordSet = new HashSet<>(wordDict);
//        int n = s.length();
//        boolean[] dp = new boolean[n + 1];
//        dp[0] = true;
//        for (int i = 0; i < n; i++) {
//            for (int len = 1; len <= n; len++) {
//                dp[i + len] |= dp[i] && wordSet.contains(s.substring(i, i + len));
//            }
//        }
//        return dp[n];
//    }

    public static void main(String[] args) {
        new M139().wordBreak("leetcode", Stream.of("leet", "code").collect(Collectors.toList()));
    }

    public boolean backtrack(String s, int idx, Set<String> wordSet, boolean[] flags) {
        if (idx == s.length()) {
            return true;
        } else if (idx > s.length()) {
            return false;
        }
        if (!flags[idx]) {
            return false;
        }
        for (int len = 1; idx + len <= s.length(); len++) {
            if (!wordSet.contains(s.substring(idx, idx + len))) {
                continue;
            }
            if (backtrack(s, idx + len, wordSet, flags)) {
                return true;
            }
        }
        flags[idx] = false;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flags = new boolean[s.length()];
        Arrays.fill(flags, true);
        return backtrack(s, 0, new HashSet<>(wordDict), flags);
    }
}