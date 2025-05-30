package cp.dojo.solution.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PacificAtlanticWaterFlow {
  public static void main(String[] args){
    PacificAtlanticWaterFlow s = new PacificAtlanticWaterFlow();
    List<List<Integer>> res = s.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
    for(List<Integer> coord : res){
      System.out.println(coord);
    }
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    Deque<int[]> pacificQueue = new ArrayDeque<>();
    Deque<int[]> atlanticQueue = new ArrayDeque<>();
    
    /*
     Anything on row 0 can go to pacific Ocean
     Anything on row-1 can go to atlantic Ocean
    */
    for(int col = 0; col < heights[0].length; ++col){
      pacificQueue.offer(new int[]{0, col});
      atlanticQueue.offer(new int[]{heights.length-1, col});
    }

    /*
     * Anything on col 0 can go to pacific ocean
     * Anything on col-1 can go to Atlantic ocean
     */
    for(int row = 0; row < heights.length; ++row){
      pacificQueue.add(new int[]{row, 0});
      atlanticQueue.offer(new int[]{row, heights[0].length-1});
    }

    boolean[][] canReachPacific = new boolean[heights.length][heights[0].length];
    boolean[][] canReachAtlantic = new boolean[heights.length][heights[0].length];
    bfs(atlanticQueue, canReachAtlantic, heights);
    bfs(pacificQueue, canReachPacific, heights);

    List<List<Integer>> result = new ArrayList<>();
    for(int row = 0; row < heights.length; ++row){
      for(int col = 0; col < heights[0].length; ++col){
        if(canReachAtlantic[row][col] && canReachPacific[row][col]){
          result.add(List.of(row, col));
        }
      }
    }
    return result;
  }

  private void bfs(Deque<int[]> queue, boolean[][] isVisited, int[][] heights){
    int[][] directions = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      isVisited[cur[0]][cur[1]] = true;
      for(int[] delta : directions){
        int x = cur[0] + delta[0];
        int y = cur[1] + delta[1];
        if(x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !isVisited[x][y] && heights[x][y] >= heights[cur[0]][cur[1]]){
          queue.offer(new int[]{x, y});
        }
      }
    }
  }
}
