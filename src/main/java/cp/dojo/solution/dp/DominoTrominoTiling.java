package cp.dojo.solution.dp;

public class DominoTrominoTiling {
  public static void main(String[] args) {
    DominoTrominoTiling s = new DominoTrominoTiling();
    System.out.println(s.numTilingsUsingRecursion(30));
    System.out.println(s.numTilings(30));
  }

  /**
   * Using DP
   * base case:
   * Board colum size is 2 * 1
   * if N == 0, board size = 0, number of ways tiles can be arranged = 0
   * if N = 1, board size = 2, number of ways tiles can be arranged = 1
   * N = 2, number of ways tiles can be arranged = 2
   * N = 3, number of ways tiles can be arranged = 5
   * pattern : fn = 2*f(n-1) + f(n-3)
   *
   * @param n
   * @return
   */
  public int numTilings(int n) {
    int mod = 1_000_000_007;
    int f0 = 0, f1 = 1, f2 = 2, f3 = 5;
    return switch (n) {
      case 0 -> f0;
      case 1 -> f1;
      case 2 -> f2;
      case 3 -> f3;
      default -> {
        for (int i = 4; i <= n; i += 1) {
          int ways = (2 * f3) % mod + f1 % mod;
          f1 = f2;
          f2 = f3;
          f3 = ways % mod;
        }
        yield f3;
      }
    };
  }

  /**
   * base case:
   * Board colum size is 2 * 1
   * if N == 0, board size = 0, number of ways tiles can be arranged = 0
   * if N = 1, board size = 2, number of ways tiles can be arranged = 1
   * N = 2, number of ways tiles can be arranged = 2
   * N = 3, number of ways tiles can be arranged = 5
   * pattern : fn = 2*f(n-1) + f(n-3)
   *
   * @param n
   * @return
   */
  public int numTilingsUsingRecursion(int n) {
    int mod = 1_000_000_007;

    return switch (n) {
      case 0 -> 0;
      case 1 -> 1;
      case 2 -> 2;
      case 3 -> 5;
      default -> ((2 * numTilingsUsingRecursion(n - 1)) % mod + numTilingsUsingRecursion(n - 3) % mod);
    } % mod;
  }
}
