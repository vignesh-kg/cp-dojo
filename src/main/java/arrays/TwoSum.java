package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum{
  public static void main(String[] args){
    TwoSum s = new TwoSum();
    System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 13}, 9)));
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> diffMap = new HashMap<>();
    int diff = -1;
    for(int i = 0; i < nums.length; ++i){
      int curNum = nums[i];
      diff = target - curNum;
      if(diffMap.containsKey(diff)){
        return new int[]{diffMap.get(diff), i};
      } else {
        diffMap.put(curNum, i);
      }
    }
    return new int[]{-1, -1};
  }
}