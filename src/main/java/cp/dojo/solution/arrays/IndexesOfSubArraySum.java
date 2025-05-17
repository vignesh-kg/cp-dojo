package cp.dojo.solution.arrays;

import java.util.ArrayList;

public class IndexesOfSubArraySum {
  public static void main(String[] args) {
    IndexesOfSubArraySum s = new IndexesOfSubArraySum();
    System.out.println(s.subarraySum(new int[]{1, 2, 3, 7, 5}, 12));
  }

  ArrayList<Integer> subarraySum(int[] arr, int target) {
    ArrayList<Integer> result = new ArrayList<>();
    int left = 0, right = 0, sum = 0;
    for (int i = 0; i < arr.length; ++i) {
      sum += arr[i];
      if (sum >= target) right = i;
      while (sum > target) {
        sum -= arr[left];
        left += 1;
      }
      if (sum == target) {
        result.add(left + 1);
        result.add(right + 1);
        return result;
      }
    }
    result.add(-1);
    return result;
  }
}