package codetop;

import java.util.LinkedList;
import java.util.List;

public class M54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = n - 1, t = 0, b = m - 1;
        int cnt = m * n;
        while (cnt != 0) {
            for (int i = l; i <= r && cnt != 0; i++, cnt--) {
                ans.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <= b && cnt != 0; i++, cnt--) {
                ans.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l && cnt != 0; i--, cnt--) {
                ans.add(matrix[b][i]);
            }
            b--;
            for (int i = b; i >= t && cnt != 0; i--, cnt--) {
                ans.add(matrix[i][l]);
            }
            l++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new M54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
