package cp.dojo.solution.bit.manipulation;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }

  public static void main(String[] args) {
    SingleNumber s = new SingleNumber();
    System.out.println(s.singleNumber(new int[]{2, 2, 1}));
  }
}
