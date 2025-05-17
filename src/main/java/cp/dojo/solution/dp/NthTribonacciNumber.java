package cp.dojo.solution.dp;

public class NthTribonacciNumber {
  public static void main(String[] args) {
    NthTribonacciNumber s = new NthTribonacciNumber();
    System.out.println(s.tribonacciUsingRecursion(4));
    System.out.println(s.tribonacciUsingRecursion(25));
    System.out.println(s.tribonacci(4));
    System.out.println(s.tribonacci(25));
  }

  /**
   * Nth Tribonacci Number using recursion
   * T0 = 0, T1 = 1, T2 = 1, Tn = Tn-1 + Tn-2 + Tn-3
   *
   * @param n
   * @return
   */
  public int tribonacciUsingRecursion(int n) {
    if (n == 0) {
      return 0;
    }
    if (n <= 2)
      return 1;
    return tribonacciUsingRecursion(n - 1) + tribonacciUsingRecursion(n - 2) + tribonacciUsingRecursion(n - 3);
  }

  /**
   * Nth Tribonacci Number using DP
   * T0 = 0, T1 = 1, T2 = 1, Tn = Tn-1 + Tn-2 + Tn-3
   *
   * @param n
   * @return
   */
  public int tribonacci(int n) {
    // base case
    if (n == 0)
      return 0;
    if (n <= 2)
      return 1;

    // f0 = f(n-3), f1 = f(n-2), f2 = f(n-1)
    int f0 = 0, f1 = 1, f2 = 1;
    for (Integer i = 3; i <= n; i += 1) {
      int fn = f0 + f1 + f2;
      f0 = f1;
      f1 = f2;
      f2 = fn;
    }
    return f2;
  }
}