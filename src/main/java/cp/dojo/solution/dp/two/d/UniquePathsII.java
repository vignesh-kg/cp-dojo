package cp.dojo.solution.dp.two.d;

public class UniquePathsII {
  public static void main(String[] args){
    UniquePathsII s = new UniquePathsII();
    int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
    System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    /*
     * If starting position itself is an obstacle
     * we cannot move further
     */
    if(obstacleGrid[0][0] == 1){
      return 0;
    }
    int[] prev = new int[obstacleGrid[0].length];
    for(int i = 0; i < obstacleGrid.length; ++i){
      int[] cur = new int[obstacleGrid[i].length];
      for(int j = 0; j < obstacleGrid[i].length; ++j){
        /*
         * There is only 1 way to reach (0,0)
         */
        if(i == 0 && j == 0){
          cur[j] = 1;
        } else if (obstacleGrid[i][j] == 1){
          /*
           * cannot reach an obstacle cell
           */
          cur[j] = 0;
        } else {
          int left = 0, up = 0;
          if(i > 0){
            up = prev[j];
          }
          if(j > 0){
            left = cur[j-1];
          }
          cur[j] = up + left;
        }
      }
      prev = cur.clone();
    }
    return prev[obstacleGrid[0].length-1];
  }
}
