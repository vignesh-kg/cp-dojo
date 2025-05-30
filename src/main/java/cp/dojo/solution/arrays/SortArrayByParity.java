package cp.dojo.solution.arrays;

import java.util.Arrays;

public class SortArrayByParity {
  public static void main(String[] args){
    SortArrayByParity s = new SortArrayByParity();
    System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{3,1,2,4})));
  }

  public int[] sortArrayByParity(int[] nums) {
    int nonEvenIndex = 0;
    for(int i = 0; i < nums.length; ++i){
      if(nums[i]%2 == 0){
        int temp = nums[i];
        nums[i] = nums[nonEvenIndex];
        nums[nonEvenIndex++] = temp;
      }
    }
    return nums;
  }
}
