package cp.dojo.solution.binary.search;

import java.util.Arrays;

public class KokoEatingBanana {

  public static void main(String[] args){
    KokoEatingBanana s = new KokoEatingBanana();
    System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 8));
  }

  public int minEatingSpeed(int[] piles, int h) {
    int low = 1, high = Integer.MIN_VALUE;
    for(int pile : piles){
      if(high < pile){
        high = pile;
      }
    }
    while(low < high){
      int mid = low + (high-low)/2;
      if(minHoursRequired(piles, mid) <= h) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return high;
  }

  private int minHoursRequired(int[] piles, int eatingSpeed){
    int minHoursRequired = 0;
    for(int pile : piles){
      minHoursRequired += pile/eatingSpeed;
      if(pile%eatingSpeed != 0) {
        minHoursRequired += 1;
      }
    }
    return minHoursRequired;
  }
}
