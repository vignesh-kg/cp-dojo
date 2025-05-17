package cp.dojo.solution.binary.search;

public class GuessNumHighOrLow {

  private final int pick = 6;

  public static void main(String[] args) {
    GuessNumHighOrLow s = new GuessNumHighOrLow();
    System.out.println(s.guessNumber(10));
  }

  public int guessNumber(int n) {
    int l = 1, r = n;
    while (l < r) {
      int mid = l + (r - l) / 2;
      int guess = guess(mid);
      if (guess == 0) {
        return mid;
      }
      if (guess < 0) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return -1;
  }

  int guess(int num) {
    if (num < pick) {
      return 1;
    }
    if (num > pick) {
      return -1;
    }
    return 0;
  }
}