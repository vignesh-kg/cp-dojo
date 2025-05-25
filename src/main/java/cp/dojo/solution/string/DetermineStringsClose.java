package cp.dojo.solution.string;

import java.util.Arrays;

public class DetermineStringsClose {
  public boolean closeStrings(String word1, String word2) {
    char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
    if (w1.length != w2.length) {
      return false;
    }
    int[] count1 = new int[26];
    int[] count2 = new int[26];
    for (char ch : w1) {
      count1[ch - 'a'] += 1;
    }
    for (char ch : w2) {
      count2[ch - 'a'] += 1;
    }
    for (int i = 0; i < 26; i += 1) {
      if ((count1[i] != 0 && count2[i] == 0) || (count1[i] == 0 && count2[i] != 0)) {
        return false;
      }
    }
    Arrays.sort(count1);
    Arrays.sort(count2);
    for (int i = 0; i < 26; i += 1) {
      if (count1[i] != count2[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    DetermineStringsClose s = new DetermineStringsClose();
    System.out.println(s.closeStrings("abc", "bca"));
    System.out.println(s.closeStrings("a", "aa"));
  }
}
