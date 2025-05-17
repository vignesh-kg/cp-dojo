package cp.dojo.solution.string;

import java.util.Arrays;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    LongestCommonPrefix s = new LongestCommonPrefix();
    System.out.println(s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    System.out.println(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
  }

  //Approach 1
  public String longestCommonPrefix(String[] strs) {
    Arrays.sort(strs);
    String s1 = strs[0], s2 = strs[strs.length - 1];
    int i = 0;
    while (i < s1.length()) {
      if (s1.charAt(i) == s2.charAt(i))
        i += 1;
      else
        break;
    }
    return s1.substring(0, i);
  }

  //Approach 2
  public String longestCommonPrefix2(String[] strs) {
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i += 1) {
      while (!strs[i].startsWith(prefix)) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) return "";
      }
    }
    return prefix;
  }
}