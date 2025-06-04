package cp.dojo.solution.binary.search;

public class CapacityToShipWithinDDays {
  public static void main(String[] args) {
    CapacityToShipWithinDDays s = new CapacityToShipWithinDDays();
    System.out.println(s.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
  }

  public int shipWithinDays(int[] weights, int days) {
    int minCapacityRequired = Integer.MIN_VALUE, maxCapacityRequired = 0;
    for (int weight : weights) {
      if (minCapacityRequired < weight) {
        minCapacityRequired = weight;
      }
      //If we want to ship all packages in 1 day
      maxCapacityRequired += weight;
    }

    int low = minCapacityRequired, high = maxCapacityRequired;
    while (low < high) {
      int mid = low + (high - low) / 2;
      int daysRequired = 1;
      int curWeight = 0;
      /*
       * On day 1, we add weights until it doesn't exceed mid
       * when weight of day 1 exceeds mid (possible capacity), we move to day 2
       */
      for (int weight : weights) {
        curWeight += weight;
        if (curWeight > mid) {
          ++daysRequired;
          curWeight = weight; // on day 2, we start from current position of weight
        }
      }
      //If daysRequired is more, we need to increase capacity of ship
      if (daysRequired > days) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }
}
