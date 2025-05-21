package cp.dojo.solution.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxKSumPairs {
  public static void main(String[] args) {
    MaxKSumPairs s = new MaxKSumPairs();
    System.out.println(s.maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
  }

  public int maxOperations(int[] nums, int k) {
    int maxOperations = 0;
    Arrays.sort(nums);
    int left = 0, right = nums.length - 1;
    while (left < right) {
      if (nums[left] > k) {
        break;
      }
      int curSum = nums[left] + nums[right];
      if (curSum == k) {
        maxOperations += 1;
        left += 1;
        right -= 1;
      } else if (curSum > k) {
        right -= 1;
      } else {
        left += 1;
      }
    }
    return maxOperations;
  }

  public int maxOperationsUsingMap(int[] nums, int k) {
    Map<Integer, Integer> diffMap = new HashMap<>();
    int maxOperations = 0;
    for (int num : nums) {
      int diff = k - num;
      if (diffMap.containsKey(diff)) {
        maxOperations += 1;
        if (diffMap.get(diff) == 1) {
          diffMap.remove(diff);
        } else {
          diffMap.put(diff, diffMap.get(diff) - 1);
        }
      } else {
        diffMap.put(num, diffMap.getOrDefault(num, 0) + 1);
      }
    }
    return maxOperations;
  }
}
