package codetop;

class M221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        new M221().maximalSquare(new char[][]{{'0', '1'}});
    }
}