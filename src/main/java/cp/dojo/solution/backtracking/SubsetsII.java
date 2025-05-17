package cp.dojo.solution.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

  public static void main(String[] args) {
    SubsetsII s = new SubsetsII();
    System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> subsetsList = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(0, nums, subsetsList, new ArrayList<>(), false);
    return subsetsList;
  }

  private void backtrack(int index, int[] nums, List<List<Integer>> subsetList, List<Integer> subset, boolean isElementPicked) {
    if (index == nums.length) {
      subsetList.add(new ArrayList<>(subset));
      return;
    }

    if (index == 0 || nums[index] != nums[index - 1] || isElementPicked) {
      subset.add(nums[index]);
      backtrack(index + 1, nums, subsetList, subset, true);
      subset.removeLast();
    }
    backtrack(index + 1, nums, subsetList, subset, false);
  }
}
