
public class GuessNumHighOrLow {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.guessNumber(10));
    }
}

class Solution {

    private final int pick = 6;

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
