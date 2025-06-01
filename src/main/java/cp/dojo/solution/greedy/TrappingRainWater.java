package cp.dojo.solution.greedy;

import java.util.Arrays;

public class TrappingRainWater {
  public static void main(String[] args){
    TrappingRainWater s = new TrappingRainWater();
    System.out.println(s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
  }

  public int trap(int[] height) {
    int[] leftWalls = new int[height.length];
    int[] rightWalls = new int[height.length];

    int leftWall = 0;
    for(int i = 0; i < height.length; ++i){
      leftWalls[i] = leftWall;
      leftWall = Math.max(leftWall, height[i]);
    }
    int rightWall = 0;
    for(int i = height.length-1; i >= 0; --i){
      rightWalls[i] = rightWall;
      rightWall = Math.max(rightWall, height[i]);
    }
    int sum = 0;
    for(int i = 0; i < height.length; ++i){
      int potentialWater = Math.min(leftWalls[i], rightWalls[i]);
      sum += Math.max(0, potentialWater-height[i]);
    }
    return sum;
  }
}
