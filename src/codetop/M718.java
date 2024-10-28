package codetop;

class M718 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        // dp[i][j]=nums1[i:]和nums2[j:]的最大相同前缀
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new M718().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 1, 1, 4, 7});
    }
}