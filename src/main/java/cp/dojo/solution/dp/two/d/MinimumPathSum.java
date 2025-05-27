package cp.dojo.solution.dp.two.d;

public class MinimumPathSum {
  public static void main(String[] args) {
    MinimumPathSum s = new MinimumPathSum();
    System.out.println(s.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
  }

  public int minPathSum(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];
    dp[0][0] = grid[0][0];
    /*
     * Base case:
     * from [0,0], 0th row and column's cost will be grid[i-1][j-1] + grid[i][j]
     * populate dp[][] with base case
     */
    for (int i = 1; i < grid.length; ++i) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int j = 1; j < grid[0].length; ++j) {
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }
    /*
     * To calculate path sum for [i, j]
     */
    for (int i = 1; i < grid.length; ++i) {
      for (int j = 1; j < grid[0].length; ++j) {
        int prevMinCost = dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
        dp[i][j] = prevMinCost + grid[i][j];
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }
}
