package dp;

import java.util.function.Function;

public class FibonacciNumber{
  public static void main(String[] args){
    Solution s = new Solution();
    System.out.println(s.fib(6));
  }
}

class Solution{
  //Approach 1 - using Recursion

  Function<Integer, Integer> fibFunction = num -> {
    if(num == 0) return 0;
    if(num == 1) return 1;
    return this.fibFunction.apply(num-1) + this.fibFunction.apply(num-2);
  };
  public int fibUsingRecursion(int n) {
    return fibFunction.apply(n);
  }

  //Approach 2 - using DP - tabulation
  public int fib(int num){
    if(num == 0) return 0;
    if(num == 1) return 1;
    Integer f0 = 0, f1 = 1;
    for(int i = 2; i <= num; i += 1){
      int sum = f0 + f1;
      f0 = f1;
      f1 = sum;
    }
    return f1;
  }
}