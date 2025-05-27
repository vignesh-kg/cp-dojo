package cp.dojo.solution.dp.two.d;

import java.util.Arrays;

public class BuyAndSellStockIII {
  public static void main(String[] args) {
    BuyAndSellStockIII s = new BuyAndSellStockIII();
    System.out.println(s.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
  }

  public int maxProfit(int[] prices) {

    int[] prevBuy = new int[3], prevSell = new int[3];
    Arrays.fill(prevBuy, 0);
    Arrays.fill(prevSell, 0);

    for (int i = prices.length - 1; i >= 0; --i) {
      int[] curBuy = new int[3], curSell = new int[3];
      for (int capacity = 1; capacity < 3; ++capacity) {
        curBuy[capacity] = Math.max(-prices[i] + prevSell[capacity], 0 + prevBuy[capacity]);
        curSell[capacity] = Math.max(prices[i] + prevBuy[capacity - 1], 0 + prevSell[capacity]);
      }
      prevBuy = curBuy.clone();
      prevSell = curSell.clone();
    }
    return prevBuy[2];
  }
}
