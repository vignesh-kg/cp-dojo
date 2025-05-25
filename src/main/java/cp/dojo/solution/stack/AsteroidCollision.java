package cp.dojo.solution.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for(int asteroid : asteroids){
      if(stack.isEmpty() || asteroid > 0){
        stack.push(asteroid);
      } else {
        while(true){
          if(stack.peek() < 0){
            stack.push(asteroid);
            break;
          } else if(stack.peek() == -asteroid){
            stack.pop();
            break;
          } else if(stack.peek() > -asteroid){
            break;
          } else {
            stack.pop();
            if(stack.isEmpty()){
              stack.push(asteroid);
              break;
            }
          }
        }
      }
    }
    int[] result = new int[stack.size()];
    for(int i = stack.size()-1; i >= 0; i -= 1){
      result[i] = stack.pop();
    }

    return result;
  }

  public static void main(String[] args){
    AsteroidCollision s = new AsteroidCollision();
    System.out.println(Arrays.toString(s.asteroidCollision(new int[]{5, 10, -5})));
  }
}
