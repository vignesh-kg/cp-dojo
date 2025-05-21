package cp.dojo.solution.arrays;

import java.util.Arrays;

public class MoveZeros {
  public static void main(String[] args){
    MoveZeros s = new MoveZeros();
    int[] nums = new int[]{0,1,0,3,12};
    s.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

  public void moveZeroes(int[] nums) {
    int zeroIndex = 0;
    for(int i = 0; i < nums.length; i += 1){
      if(nums[i] != 0){
        int temp = nums[i];
        nums[i] = nums[zeroIndex];
        nums[zeroIndex] = temp;
        zeroIndex += 1;
      }
    }
  }
}
