package cp.dojo.solution.arrays;

public class IncreasingTripletSubSequence {
  public static void main(String[] args) {
    IncreasingTripletSubSequence s = new IncreasingTripletSubSequence();
    System.out.println(s.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
    System.out.println(s.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    System.out.println(s.increasingTriplet(new int[]{1, 1, 1, 1, 1}));
  }

  public boolean increasingTriplet(int[] nums) {
    int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num <= num1) {
        num1 = num;
      } else if (num <= num2) {
        num2 = num;
      } else {
        return true;
      }
    }
    return false;
  }
}