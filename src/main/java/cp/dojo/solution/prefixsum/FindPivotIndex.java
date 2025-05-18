package cp.dojo.solution.prefixsum;

public class FindPivotIndex {
  public static void main(String[] args){
    FindPivotIndex s = new FindPivotIndex();
    System.out.println(s.pivotIndex(new int[]{1,7,3,6,5,6}));
  }

  public int pivotIndex(int[] nums) {
    int rightSum = 0;
    for(int num : nums){
      rightSum += num;
    }
    int leftSum = 0;
    for(int i = 0; i < nums.length; i += 1){
      if(leftSum == rightSum-nums[i]-leftSum){
        return i;
      }
      leftSum += nums[i];
    }
    return -1;
  }
}
