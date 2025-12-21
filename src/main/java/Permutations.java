import java.util.List;
import java.util.ArrayList;

public class Permutations {
  public static void main(String[] args){
    Solution s = new Solution();
    System.out.println(s.permute(new int[]{1,2,3}));
  }
}

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtrack(used, res, new ArrayList<>(), nums);
    return res;
  }

  private void backtrack(boolean[] used, List<List<Integer>> res, List<Integer> temp, int[] nums) {
    if(temp.size() == nums.length){
      res.add(new ArrayList<>(temp));
      return;
    }

    for(int i = 0; i < nums.length; ++i){
      if(!used[i]){
        temp.add(nums[i]);
        used[i] = true;
        backtrack(used, res, temp, nums);
        temp.remove(temp.size()-1);
        used[i] = false;
      }
    }
  }
}