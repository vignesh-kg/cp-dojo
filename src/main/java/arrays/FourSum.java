package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public static void main(String[] args) {
    FourSum s = new FourSum();
    for (List<Integer> triplet : s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)) {
      System.out.println(triplet);
    }
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      if (i != 0 && nums[i] == nums[i - 1]) continue;
      for (int j = i + 1; j < nums.length; ++j) {
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;
        int k = j + 1, l = nums.length - 1;
        long intermediateTarget = (long)target - nums[i] - nums[j];
        while (k < l) {
          long sum = (long) nums[k];
          sum += nums[l];
          if (sum == intermediateTarget) {
            res.add(List.of(nums[i], nums[j], nums[k], nums[l]));
            ++k;
            --l;

            while (k < l && nums[k] == nums[k - 1]) ++k;
            while (k < l && nums[l] == nums[l + 1]) --l;
          } else if (sum < intermediateTarget) ++k;
          else --l;
        }
      }
    }
    return res;
  }
}
