package cp.dojo.solution.monotonic.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

  public static void main(String[] args) {
    DailyTemperatures s = new DailyTemperatures();
    System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
  }

  public int[] dailyTemperatures(int[] temperatures) {
    int len = temperatures.length;
    int[] result = new int[len];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < len; i += 1) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        result[stack.peek()] = i - stack.pop();
      }
      stack.push(i);
    }
    return result;
  }
}
