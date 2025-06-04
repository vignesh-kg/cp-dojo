package cp.dojo.solution.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
  public static void main(String[] args) {
    MinimumAbsoluteDifference s = new MinimumAbsoluteDifference();
    List<List<Integer>> pairs = s.minimumAbsDifference(new int[]{4, 2, 1, 3});
    for (List<Integer> pair : pairs) {
      System.out.println(pair);
    }
  }

  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    int minDifference = Integer.MAX_VALUE;
    Arrays.sort(arr);
    for (int i = 1; i < arr.length; ++i) {
      if (minDifference > (arr[i] - arr[i - 1])) {
        minDifference = arr[i] - arr[i - 1];
      }
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 1; i < arr.length; ++i) {
      if (arr[i] - arr[i - 1] == minDifference) {
        result.add(List.of(arr[i - 1], arr[i]));
      }
    }
    return result;
  }
}
