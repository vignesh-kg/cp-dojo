package graph;

import java.util.function.Consumer;
import java.util.stream.IntStream;

public class NumberOfProvinces {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
  }
}

class Solution {
  public int findCircleNum(int[][] isConnected) {
    int connectedProvince = 0;
    boolean[] isVisited = new boolean[isConnected.length];
    Consumer<Integer> dfs = new Consumer<Integer>() {
      @Override
      public void accept(Integer i) {
        Consumer<Integer> recursiveDFS = this::accept;
        isVisited[i] = true;
        IntStream.range(0, isConnected.length).forEach(neighbour -> {
          if (!isVisited[neighbour] && isConnected[i][neighbour] == 1)
            recursiveDFS.accept(neighbour);
        });
      }
    };

    for (int i = 0; i < isConnected.length; ++i) {
      if (!isVisited[i]) {
        dfs.accept(i);
        ++connectedProvince;
      }
    }
    return connectedProvince;
  }
}