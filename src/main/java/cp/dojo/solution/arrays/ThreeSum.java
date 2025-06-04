package cp.dojo.solution.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public static void main(String[] args) {
    ThreeSum s = new ThreeSum();
    List<List<Integer>> triplets = s.threeSum(new int[]{-1,0,1,2,-1,-4});
    for(List<Integer> tripl : triplets){
      System.out.println(tripl);
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {
    //Sort nums
    Arrays.sort(nums);
    List<List<Integer>> triplets = new ArrayList<>();
    for(int i = 0; i < nums.length; ++i){
      //If i != 0 && nums[i] == nums[i-1] skip computation
      if(i != 0 && nums[i] == nums[i-1]){
        continue;
      }
      int low = i+1, high = nums.length-1;
      while(low < high){
        int sum = nums[i] + nums[low] + nums[high];
        if(sum == 0){
          triplets.add(List.of(nums[i], nums[low], nums[high]));
          ++low; --high;
          while(low < high && nums[low] == nums[low-1]){
            ++low;
          }
          while(low < high && nums[high] == nums[high+1]){
            --high;
          }
        } else if(sum > 0){
          --high;
        } else {
          ++low;
        }
      }
    }
    return triplets;
  }
}
