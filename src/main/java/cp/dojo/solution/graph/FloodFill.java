package cp.dojo.solution.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FloodFill {
  public static void main(String[] args){
    int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
    FloodFill s = new FloodFill();
    image = s.floodFill(image, 1, 1, 2);
    for(int[] row : image){
      System.out.println(Arrays.toString(row));
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if(image[sr][sc] == color){
      return image;
    }
    int srcColor = image[sr][sc];
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{sr, sc});
    image[sr][sc] = color;
    int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
    while(!queue.isEmpty()){
      int[] curCoordinates = queue.poll();
      for(int[] delta : directions){
        int x = curCoordinates[0] + delta[0];
        int y = curCoordinates[1] + delta[1];
        if((x >= 0 && x < image.length && y >=0 && y < image[0].length) && image[x][y] == srcColor && image[x][y] != color){
          queue.offer(new int[]{x,y});
          image[x][y] = color;
        }
      }
    }
    return image;
  }
}
