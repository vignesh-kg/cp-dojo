import java.util.List;
import java.util.ArrayList;

public class Subsets{
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.subsets(new int[]{1,2,3}));
  }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int index){
      if(index == nums.length){
        result.add(new ArrayList<>(temp));
        return;
      }

      temp.add(nums[index]);
      backtrack(result, temp, nums, index+1);
      temp.remove(temp.size()-1);
      backtrack(result, temp, nums, index+1);      
    }
}