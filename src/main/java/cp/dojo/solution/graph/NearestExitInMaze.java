package cp.dojo.solution.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class NearestExitInMaze {
  public static void main(String[] args) {
    NearestExitInMaze s = new NearestExitInMaze();
    System.out.println(s.nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}
    }, new int[]{1, 2}));
  }

  public int nearestExit(char[][] maze, int[] entrance) {
    int m = maze.length, n = maze[0].length;
    int steps = 0;
    Deque<int[]> queue = new ArrayDeque<>();
    queue.offer(entrance);
    int x, y;
    maze[entrance[0]][entrance[1]] = '+'; // updating visited empty block with a wall
    int[][] delta = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!queue.isEmpty()) {
      //checking if path exist in possible empty spaces
      int size = queue.size();
      for (int i = 0; i < size; i += 1) {
        int[] currentPosition = queue.poll();
        //We have reached the end of maze
        if ((currentPosition[0] == 0 || currentPosition[0] == m - 1 || currentPosition[1] == 0 || currentPosition[1] == n - 1)
            && (currentPosition[0] != entrance[0] || currentPosition[1] != entrance[1])) {
          return steps;
        }
        for (int[] d : delta) {
          x = d[0] + currentPosition[0];
          y = d[1] + currentPosition[1];

          //No further path exist
          if ((x < 0 || x >= m || y < 0 || y >= n) || maze[x][y] == '+') {
            continue;
          }


          queue.offer(new int[]{x, y});
          maze[x][y] = '+';
        }
      }
      steps += 1;
    }
    return -1;
  }
}
