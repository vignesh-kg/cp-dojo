package cp.dojo.solution.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {
  public static void main(String[] args) {
    RottingOranges s = new RottingOranges();
    int[][] oranges = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.out.println(s.orangesRotting(oranges));
  }

  public int orangesRotting(int[][] grid) {
    Deque<int[]> queue = new ArrayDeque<>();
    int freshOranges = 0;

    for (int i = 0; i < grid.length; i += 1) {
      for (int j = 0; j < grid[0].length; j += 1) {
        if (grid[i][j] == 2) {
          queue.offer(new int[]{i, j});
        } else if (grid[i][j] == 1) {
          freshOranges += 1;
        }
      }
    }
    if (freshOranges == 0) {
      return 0;
    }
    if (queue.isEmpty()) {
      return -1;
    }
    int minutes = -1;
    int[][] delta = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 0; i < n; i += 1) {
        int[] curPos = queue.poll();
        for (int[] del : delta) {
          int x = curPos[0] + del[0];
          int y = curPos[1] + del[1];
          if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            grid[x][y] = 2;
            freshOranges -= 1;
            queue.offer(new int[]{x, y});
          }
        }
      }
      minutes += 1;
    }
    return freshOranges == 0 ? minutes : -1;
  }
}
