import java.util.ArrayList;
import java.util.List;

public class Subsets{
  public static void main(String[] args){
    Solution s = new Solution();
    System.out.println(s.subsets(new int[]{1,2,3}));
  }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> subsetList = new ArrayList<>();
      backtrack(0, nums, subsetList, new ArrayList<>());
      return subsetList;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> subsetList, List<Integer> subset){
      if(index == nums.length){
        subsetList.add(new ArrayList<>(subset));
        return;
      }

      //Include element at index
      subset.add(nums[index]);
      backtrack(index+1, nums, subsetList, subset);

      //Exclude element at Index
      subset.remove(subset.size()-1);
      backtrack(index+1, nums, subsetList, subset);
    }
}