package cp.dojo.solution.arrays;

public class CanPlaceFlowers {

  public static void main(String[] args) {
    CanPlaceFlowers s = new CanPlaceFlowers();
    System.out.println(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    System.out.println(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
  }

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n == 0) {
      return true;
    }
    for (int i = 0; i < flowerbed.length; i += 1) {
      if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
        flowerbed[i] = 1;
        --n;
      }
      if (n == 0) {
        return true;
      }
    }
    return false;
  }
}
