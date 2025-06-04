package cp.dojo.solution.math;

import java.util.Arrays;

public class PlusOne {
  public static void main(String[] args){
    PlusOne s = new PlusOne();
    System.out.println(Arrays.toString(s.plusOne(new int[]{8,9,9})));
    System.out.println(Arrays.toString(s.plusOne(new int[]{9,9,9})));
  }

  public int[] plusOne(int[] digits) {
    for(int i = digits.length-1; i >= 0; --i){
      if(digits[i] + 1 != 10){
        ++digits[i];
        return digits;
      }
      digits[i] = 0;
    }
    int[] newDigits = new int[digits.length+1];
    newDigits[0] = 1;
    return newDigits;
  }
}
