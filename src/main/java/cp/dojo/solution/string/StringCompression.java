package cp.dojo.solution.string;

import java.util.Arrays;

public class StringCompression {
  public static void main(String[] args) {
    StringCompression s = new StringCompression();
    char[] input = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    System.out.println(s.compress(input) + " " + Arrays.toString(input));
  }

  public int compress(char[] chars) {
    char prevChar = chars[0];
    StringBuilder compressedString = new StringBuilder();
    int count = 1;
    for (int i = 1; i < chars.length; i += 1) {
      if (chars[i] == prevChar) {
        count += 1;
      } else {
        compressedString.append(prevChar);
        if (count > 1) {
          compressedString.append(count);
        }
        count = 1;
        prevChar = chars[i];
      }
    }
    compressedString.append(prevChar);
    if (count > 1) {
      compressedString.append(count);
    }
    char[] compressedStrArr = compressedString.toString().toCharArray();
    int i = 0;
    for (char ch : compressedStrArr) {
      chars[i++] = ch;
    }
    return compressedString.length();
  }
}
