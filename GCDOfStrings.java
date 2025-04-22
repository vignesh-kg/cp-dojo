import java.util.Scanner;
import java.util.function.BiFunction;

public class GCDOfStrings {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Solution s = new Solution();
    System.out.println(s.gcdOfStrings(sc.nextLine(), sc.nextLine()));
  }
}


class Solution{
  public String gcdOfStrings(String str1, String str2) {
    if(!(str1+str2).equals(str2+str1)) return "";

    BiFunction<Integer, Integer, Integer> gcd = (l1, l2) -> {
      while(l2 != 0){
        int temp = l2;
        l2 = l1%l2;
        l1 = temp;
      }
      return l1;
    };
    return str1.substring(0, gcd.apply(str1.length(), str2.length()));
  }
}