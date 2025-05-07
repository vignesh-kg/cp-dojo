package dp;

public class ClimbingStairs {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.climbStairsUsingRecursion(3));
    System.out.println(s.climbStairs(3));
  }
}

class Solution {
  //Approach using Recursion
  public int climbStairsUsingRecursion(int n) {
      if(n == 0 || n == 1) return 1;
      return climbStairsUsingRecursion(n-1) + climbStairsUsingRecursion(n-2);
  }

  //Approach using Tabulation
  public int climbStairs(int n) {
    Integer f0 = 1, f1 = 1;
    for(int i = 2; i <= n; i += 1){
      int possibleWays = f0 + f1;
      f0 = f1;
      f1 = possibleWays;
    }
    return f1;
}
}