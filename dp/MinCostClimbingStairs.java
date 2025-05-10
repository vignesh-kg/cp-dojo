package dp;

public class MinCostClimbingStairs {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minCostClimbingStairsUsingRecursion(new int[] { 10, 15, 20 }));
    System.out.println(s.minCostClimbingStairs(new int[] { 10, 15, 20 }));
    System.out.println(s.minCostClimbingStairs(new int[] { 1,100,1,1,1,100,1,1,100,1 }));
  }
}

class Solution {

  public int minCostClimbingStairs(int[] cost) {
    if(cost.length == 2)
      return Math.min(cost[0], cost[1]);
    //f0 = 1 step taken initially, f1 = 2 steps taken initially
    int f0 = cost[0], f1 = cost[1];
    for(int i = 2; i < cost.length; i += 1){
      int curCost = cost[i] + Math.min(f0, f1);
      f0 = f1;
      f1 = curCost;
    }
    return Math.min(f0, f1);
  }

  public int minCostClimbingStairsUsingRecursion(int[] cost) {
    return Math.min(minCostClimbingStairsFunction(0, cost), minCostClimbingStairsFunction(1, cost));
  }

  private int minCostClimbingStairsFunction(int index, int[] cost) {
    if (index >= cost.length)
      return 0;
    if (index >= cost.length - 2)
      return cost[index];

    return cost[index]
        + Math.min(minCostClimbingStairsFunction(index + 1, cost), minCostClimbingStairsFunction(index + 2, cost));

  }
}