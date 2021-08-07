package leetcode;

/**
 * @ClassName MaxIsland105
 * @Description 岛屿的最大面积
 * https://leetcode-cn.com/problems/ZL6zAn/
 * @date 2021/8/4 22:02
 * @Version 1.0
 */
public class MaxIsland105 {
        int rows;
        int cols;
        boolean[][] visited;
        int[][] grid;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int cnt = 0;

        public int maxAreaOfIsland(int[][] grid) {
            rows = grid.length;
            cols = grid[0].length;
            visited = new boolean[rows][cols];
            this.grid = grid;
            int ans = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        ans = Math.max(ans, cnt);
                        cnt = 0;
                    }
                }
            }
            return ans;
        }

        public void dfs(int row, int col) {
            this.cnt ++;
            visited[row][col] = true;
            for (int[] dir : dirs) {
                int nr = row + dir[0], nc = col + dir[1];
                if (inGrid(nr, nc) && !visited[nr][nc] && grid[nr][nc] == 1) {
                    dfs(nr, nc);
                }
            }
        }

        public boolean inGrid(int row, int col) {
            return row >= 0 && col >= 0 && row < rows && col < cols;
        }
}
