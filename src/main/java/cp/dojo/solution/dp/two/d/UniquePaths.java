package cp.dojo.solution.dp.two.d;

public class UniquePaths {

  public static void main(String[] args) {
    UniquePaths s = new UniquePaths();
    System.out.println(s.uniquePathsUsingRecursion(3, 7));
    System.out.println(s.uniquePathsUsingRecursion(3, 2));
    System.out.println(s.uniquePaths(3, 7));
    System.out.println(s.uniquePaths(3, 2));
  }

  public int uniquePaths(int m, int n) {
    int[] prev = new int[n]; // represents dp[i-1][j]
    for (int i = 0; i < m; i += 1) {
      int[] cur = new int[n]; //represents dp[i][j]
      for (int j = 0; j < n; j += 1) {
        if (i == 0 && j == 0) {
          cur[j] = 1;
        } else {
          int up = 0, left = 0;
          if (i > 0) { //Bot can climb down
            up = prev[j];
          }
          if (j > 0) { // Bot can go left
            left = cur[j - 1];
          }
          cur[j] = up + left;
        }
      }
      prev = cur;
    }
    return prev[n - 1];
  }

  public int uniquePathsUsingRecursion(int m, int n) {
    return 1 + recursive(0, 0, m - 1, n - 1);
  }

  private int recursive(int i, int j, int m, int n) {
    if (i >= m || j >= n) {
      return 0;
    }

    return 1 + recursive(i + 1, j, m, n) + recursive(i, j + 1, m, n);
  }
}
