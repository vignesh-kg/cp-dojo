package cp.dojo.solution.graph;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutes {
  public static void main(String[] args) {
    ReorderRoutes s = new ReorderRoutes();
    int[][] connections = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
    System.out.println(s.minReorder(6, connections));
  }

  public int minReorder(int n, int[][] connections) {
    List<List<int[]>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i += 1) {
      adjList.add(new ArrayList<>());
    }
    for (int[] connection : connections) {
      adjList.get(connection[0]).add(new int[]{connection[1], 1});
      adjList.get(connection[1]).add(new int[]{connection[0], 0});
    }
    boolean[] isVisited = new boolean[n];

    return dfs(0, adjList, isVisited);
  }

  private int dfs(int node, List<List<int[]>> adjList, boolean[] isVisited) {
    int direction = 0;
    isVisited[node] = true;
    for (int[] nextNode : adjList.get(node)) {
      if (!isVisited[nextNode[0]]) {
        direction += nextNode[1] + dfs(nextNode[0], adjList, isVisited);
      }
    }
    return direction;
  }
}