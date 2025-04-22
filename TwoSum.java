import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    int[] input = new int[]{2, 7, 11, 15};
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.twoSum(input, 17)));
  }
}

class Solution{
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> diffMap = new HashMap<>();
    for(int i = 0; i < nums.length; ++i){
      int diff = target - nums[i];
      if(diffMap.containsKey(diff)) return new int[]{diffMap.get(diff), i};
      diffMap.put(nums[i],i);
    }

    return new int[]{-1, -1};
  }
}