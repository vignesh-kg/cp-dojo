package cp.dojo.solution.stack;

import java.util.Stack;

public class RemoveStarsFromString {
  public String removeStarsUsingStack(String s) {
    Stack<Character> stack = new Stack<>();
    char[] sArr = s.toCharArray();
    for (char ch : sArr) {
      if (ch != '*') {
        stack.push(ch);
      } else if (!stack.isEmpty()) {
        stack.pop();
      }
    }
    StringBuilder res = new StringBuilder();
    while(!stack.isEmpty()){
      res.insert(0, stack.pop());
    }
    return res.toString();
  }

  public String removeStars(String s) {
    StringBuilder result = new StringBuilder();
    char[] sArr = s.toCharArray();
    for(char ch : sArr){
      if(ch != '*'){
        result.append(ch);
      } else {
        result.deleteCharAt(result.length()-1);
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    RemoveStarsFromString s = new RemoveStarsFromString();
    System.out.println(s.removeStars("leet**cod*e"));
  }
}
