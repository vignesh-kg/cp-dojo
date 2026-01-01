import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne s = new PlusOne();
        System.out.println(Arrays.toString(s.plusOne(new int[] { 9 })));
    }

    public int[] plusOne(int[] digits) {
        final int len = digits.length;
        for (int i = len - 1; i >= 0; --i) {
            ++digits[i];
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
