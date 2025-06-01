package cp.dojo.solution.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
  public static void main(String[] args) {
    NetworkDelayTime s = new NetworkDelayTime();
    //System.out.println(s.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    System.out.println(s.networkDelayTime(new int[][]{{1, 2, 2}, {2, 1, 3}}, 2, 2));
  }

  public int networkDelayTime(int[][] times, int n, int k) {
    List<List<NetworkNode>> adjList = new ArrayList<>();
    for (int i = 0; i < n + 1; ++i) {
      adjList.add(new ArrayList<>());
    }
    for (int[] edge : times) {
      adjList.get(edge[0]).add(new NetworkNode(edge[1], edge[2]));
    }

    PriorityQueue<NetworkNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
    queue.add(new NetworkNode(k, 0));
    int[] visitedTime = new int[n + 1];
    Arrays.fill(visitedTime, Integer.MAX_VALUE);
    visitedTime[k] = 0;
    while (!queue.isEmpty()) {
      NetworkNode node = queue.poll();
      for (NetworkNode nextNode : adjList.get(node.val)) {
        if (node.weight + nextNode.weight < visitedTime[nextNode.val]) {
          visitedTime[nextNode.val] = node.weight + nextNode.weight;
          nextNode.weight = visitedTime[nextNode.val];
          queue.add(nextNode);
        }
      }
    }

    int maxTimeRequired = 0;
    for (int i = 1; i <= n; ++i) {
      if (visitedTime[i] == Integer.MAX_VALUE) {
        return -1;
      }
      maxTimeRequired = Math.max(maxTimeRequired, visitedTime[i]);
    }
    return maxTimeRequired;
  }
}

class NetworkNode {
  int val;
  int weight;

  NetworkNode(int val, int weight) {
    this.val = val;
    this.weight = weight;
  }
}