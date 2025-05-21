package cp.dojo.solution.arrays;

public class ContainerWithMostWater {
  public static void main(String[] args){
    ContainerWithMostWater s = new ContainerWithMostWater();
    System.out.println(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
  }

  public int maxArea(int[] height) {
    int maxArea = Integer.MIN_VALUE;
    int left = 0, right = height.length-1;
    while(left < right){
      int currentArea = Math.min(height[left], height[right]) * (right-left);
      if(maxArea < currentArea) {
        maxArea = currentArea;
      }
      if(height[left] < height[right]){
        left += 1;
      } else {
        right -= 1;
      }
    }
    return maxArea;
  }
}
