import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class IndexesOfSubArraySum {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.subarraySum(new int[]{1,2,3,7,5}, 12));
  }
}

class Solution {
  ArrayList<Integer> subarraySum(int[] arr, int target) {
      ArrayList<Integer> result = new ArrayList<>();
      Integer left = 0, right = 0, sum = 0;
      for(Integer i = 0; i < arr.length; ++i){
        sum += arr[i];
        if(sum >= target) right = i;
        while(sum > target){
          sum -= arr[left];
          left += 1;
        }
        if(sum == target){
          result.add(left+1);
          result.add(right+1);
          return result;
        }
      }
      result.add(-1);
      return result;
  }
}