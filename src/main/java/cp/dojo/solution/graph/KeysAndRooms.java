package cp.dojo.solution.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {

  public static void main(String[] args){
    KeysAndRooms s = new KeysAndRooms();
    System.out.println(s.canVisitAllRooms(Arrays.asList(List.of(1), List.of(2), List.of(3), new ArrayList<>())));
  }

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    /*
     * Approach:
     * Total number of rooms = rooms.size()
     * isVisited[rooms.size()] to keep track of visited rooms
     * run DFS once, starting from 0
     * if isVisited has all it's values as True return True else return false
     */
    boolean[] isVisited = new boolean[rooms.size()];
    dfs(0, isVisited, rooms);
    for(boolean visited : isVisited){
      if(!visited){
        return false;
      }
    }
    return true;
  }

  private void dfs(int node, boolean[] isVisited, List<List<Integer>> rooms){
    isVisited[node] = true;
    for(int neighbour : rooms.get(node)){
      if(!isVisited[neighbour]){
        dfs(neighbour, isVisited, rooms);
      }
    }
  }
}
