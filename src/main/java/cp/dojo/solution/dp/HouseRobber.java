package cp.dojo.solution.dp;

public class HouseRobber {
  public static void main(String[] args) {
    HouseRobber s = new HouseRobber();
    System.out.println(s.robUsingRecursion(new int[]{1, 2, 3, 1}));
    System.out.println(s.rob(new int[]{1, 2, 3, 1}));
  }

  //Approach using Recursion
  public int robUsingRecursion(int[] nums) {
    return robHouse(nums, 0);
  }

  private int robHouse(int[] nums, int index) {
    if (index >= nums.length) return 0;
    int maxRob = Math.max(nums[index] + robHouse(nums, index + 2), robHouse(nums, index + 1));
    return maxRob;
  }

  //Approach using Tabulation
  public int rob(int[] nums) {
    int notPick = 0, pick = nums[0];
    for (int i = 1; i < nums.length; i += 1) {
      int maxRob = Math.max(nums[i] + notPick, pick);
      notPick = pick;
      pick = maxRob;
    }
    return pick;
  }
}