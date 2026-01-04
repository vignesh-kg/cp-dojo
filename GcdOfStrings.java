import java.util.function.BiFunction;

public class GcdOfStrings {
  public static void main(String[] args) {
    GcdOfStrings s = new GcdOfStrings();
    System.out.println(s.gcdOfStrings("ABCABC", "ABC"));
  }

  public String gcdOfStrings(String str1, String str2) {
    if (!(str1 + str2).equals(str2 + str1)) {
      return "";
    }
    return str1.substring(0, gcd(str1.length(), str2.length()));
  }

  private int gcd(int a, int b) {
    if (b != 0) {
      return gcd(b, a % b);
    }
    return a;
  }
}
