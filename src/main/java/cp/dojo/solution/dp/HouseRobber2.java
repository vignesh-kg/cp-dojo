package cp.dojo.solution.dp;

public class HouseRobber2 {
  public static void main(String[] args) {
    HouseRobber2 s = new HouseRobber2();
    System.out.println(s.rob(new int[]{2, 3, 2}));
  }

  public int rob(int[] nums) {
    if (nums.length <= 1) return nums[0];
    return Math.max(robHouse(nums, 0, nums.length - 1), robHouse(nums, 1, nums.length));
  }

  private int robHouse(int[] nums, int start, int end) {
    int notPick = 0, pick = nums[start];
    for (int i = start + 1; i < end; i += 1) {
      int maxRob = Math.max(nums[i] + notPick, pick);
      notPick = pick;
      pick = maxRob;
    }
    return pick;
  }
}