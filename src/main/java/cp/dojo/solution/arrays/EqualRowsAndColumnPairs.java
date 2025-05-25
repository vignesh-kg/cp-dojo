package cp.dojo.solution.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualRowsAndColumnPairs {
  public static void main(String[] args) {
    EqualRowsAndColumnPairs s = new EqualRowsAndColumnPairs();
    System.out.println(s.equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
  }

  public int equalPairs(int[][] grid) {
    int result = 0;
    Map<List<Integer>, Integer> rowMap = new HashMap<>();
    for (int[] row : grid) {
      List<Integer> ri = new ArrayList<>();
      for (int r : row) {
        ri.add(r);
      }
      rowMap.put(ri, rowMap.getOrDefault(ri, 0) + 1);
    }

    for (int i = 0; i < grid.length; i += 1) {
      List<Integer> ci = new ArrayList<>();
      for (int j = 0; j < grid[0].length; j += 1) {
        ci.add(grid[j][i]);
      }

      if (rowMap.containsKey(ci)) {
        result += rowMap.get(ci);
      }
    }
    return result;
  }
}
