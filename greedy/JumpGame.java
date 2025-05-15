package greedy;

public class JumpGame {
  public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.canJump(new int[]{2,3,1,1,4}));
      System.out.println(s.canJump(new int[]{3,2,1,0,4}));
  }
}

class Solution {
    public boolean canJump(int[] nums) {
        int maxJumpPossible = 0;
        for(int i = 0; i < nums.length; i += 1){
          if(maxJumpPossible < i){
            return false;
          }

          maxJumpPossible = Math.max(maxJumpPossible, i + nums[i]);
          if(maxJumpPossible >= nums.length) {
            return true;
          }
        }
        return true;
    }
}