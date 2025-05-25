package cp.dojo.solution.stack;

import java.util.Stack;

public class DecodeString {
  public static void main(String[] args) {
    DecodeString s = new DecodeString();
    System.out.println(s.decodeString("3[a]2[bc]"));
    System.out.println(s.decodeString("3[a2[c]]"));
  }

  public String decodeString(String s) {
    StringBuilder res = new StringBuilder();
    Stack<String> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (ch != ']') {
        stack.push(String.valueOf(ch));
      } else {
        StringBuilder subString = new StringBuilder();
        String times = "";

        while (!stack.peek().equals("[")) {
          subString.insert(0, stack.pop());
        }
        stack.pop();
        while (!stack.isEmpty() && stack.peek().matches("\\d+")) {
          times = stack.pop() + times;
        }
        String substr = subString.toString();
        for (int i = 0; i < Integer.parseInt(times); i += 1) {
          stack.push(substr);
        }
      }
    }
    while(!stack.isEmpty()){
      res.insert(0, stack.pop());
    }
    return res.toString();
  }
}
