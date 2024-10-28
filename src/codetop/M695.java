package codetop;

import java.util.LinkedList;
import java.util.Queue;

class M695 {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int traversal(int[][] grid, boolean[][] visited, int x, int y) {
        int area = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            area++;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length &&
                        !visited[nx][ny] && grid[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    ans = Math.max(traversal(grid, visited, i, j), ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new M695().maxAreaOfIsland(new int[][]{
                {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}
        });
    }
}