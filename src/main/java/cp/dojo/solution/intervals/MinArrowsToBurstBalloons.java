package cp.dojo.solution.intervals;

import java.util.Arrays;

public class MinArrowsToBurstBalloons {

  public static void main(String[] args) {
    MinArrowsToBurstBalloons s = new MinArrowsToBurstBalloons();
    System.out.println(s.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
  }

  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
    int arrowsRequired = points.length;
    int prevEnd = points[0][1];
    for(int i = 1; i < points.length; i += 1){
      if(prevEnd >= points[i][0]){
        arrowsRequired -= 1;
        prevEnd = Math.min(prevEnd, points[i][1]);
      } else {
        prevEnd = points[i][1];
      }
    }
    return arrowsRequired;
  }
}
