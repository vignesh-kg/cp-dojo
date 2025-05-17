package cp.dojo.solution.binary.search;

import java.util.Arrays;

public class SpellsAndPotions {

  public static void main(String[] args) {
    SpellsAndPotions s = new SpellsAndPotions();
    System.out.println(Arrays.toString(s.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
  }

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int[] res = new int[spells.length];
    Arrays.sort(potions);
    for (int i = 0; i < spells.length; i += 1) {
      int low = 0, high = potions.length - 1;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        long prod = (long) potions[mid] * spells[i];
        if (prod >= success) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      res[i] = potions.length - 1 - high;
    }
    return res;
  }
}