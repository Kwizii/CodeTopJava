package codetop;

public class M5 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String ans = "";
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + l - 1;
                if (j >= s.length()) break;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && l > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new M5().longestPalindrome("cbbd");
    }
}
