import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.permuteUnique(new int[] { 1, 1, 2 }));
  }
}

class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> res = new HashSet<>();
    backtrack(res, new ArrayList<>(), new boolean[nums.length], nums);
    return new ArrayList<>(res);
  }

  private void backtrack(Set<List<Integer>> res, List<Integer> temp, boolean[] used, int[] nums) {
    if (temp.size() == nums.length) {
      res.add(new ArrayList<>(temp));
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (!used[i]) {
        temp.add(nums[i]);
        used[i] = true;
        backtrack(res, temp, used, nums);
        temp.remove(temp.size() - 1);
        used[i] = false;
      }
    }
  }
}