package cp.dojo.solution.dp;

import java.util.List;

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    //A String with no chars can be segmented
    dp[0] = true;

    //Traverse through the String
    for (int i = 1; i <= s.length(); ++i) {
      //Traverse through words in dict
      for (String word : wordDict) {
        //check if word is part of string
        int substringStart = i - word.length();
        if (substringStart >= 0 && dp[substringStart] && s.substring(substringStart, i).equals(word)) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args) {
    WordBreak s = new WordBreak();
    System.out.println(s.wordBreak("leetcode", List.of("leet", "code")));
    System.out.println(s.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
  }
}
