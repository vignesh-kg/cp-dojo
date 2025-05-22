package cp.dojo.solution.string;

public class MaxVowelsInSubString {
  public static void main(String[] args) {
    MaxVowelsInSubString s = new MaxVowelsInSubString();
    System.out.println(s.maxVowels("abciiidef", 3));
  }

  public int maxVowels(String s, int k) {
    char[] sArr = s.toCharArray();
    int maxVowels = 0;
    for (int i = 0; i < k; i += 1) {
      if (isVowel(sArr[i])) {
        maxVowels += 1;
      }
    }
    int curVowels = maxVowels;
    for (int i = k; i < sArr.length; i += 1) {
      if (isVowel(sArr[i - k])) {
        curVowels -= 1;
      }
      if (isVowel(sArr[i])) {
        curVowels += 1;
      }
      if (maxVowels < curVowels) {
        maxVowels = curVowels;
      }
    }
    return maxVowels;
  }

  private boolean isVowel(char ch) {
    return switch (ch) {
      case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
      default -> false;
    };
  }
}
