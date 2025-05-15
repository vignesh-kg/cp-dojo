public class IncreasingTripletSubSequence {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.increasingTriplet(new int[]{1,2,3,4,5}));
    System.out.println(s.increasingTriplet(new int[]{5,4,3,2,1}));
    System.out.println(s.increasingTriplet(new int[]{1,1,1,1,1}));
  }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i += 1){
          if(nums[i] <= num1){
            num1 = nums[i];
          } else if(nums[i] <= num2 ){
            num2 = nums[i];
          } else {
            return true;
          }           
        }
        return false;
    }
}