package greedy;

public class JumpGame2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(s.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(s.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(s.jump(new int[]{0}));
        System.out.println(s.jump(new int[]{2, 0, 0}));
    }
}

class Solution {

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int maxJumpPossible = 0, curJumpPosition = 0, jumpSoFar = 0;
        for (int i = 0; i < nums.length; i += 1) {
            maxJumpPossible = Math.max(maxJumpPossible, i + nums[i]);
            if (maxJumpPossible >= nums.length - 1) {
                jumpSoFar += 1;
                break;
            }
            //Increment Jump as we reach current index
            if (curJumpPosition == i) {
                curJumpPosition = maxJumpPossible;
                jumpSoFar += 1;
            }
        }
        return jumpSoFar;
    }
}
