package cp.dojo.solution.dp.two.d;

import java.util.Arrays;

public class BuyAndSellStockIV {
  public static void main(String[] args){
    BuyAndSellStockIV s = new BuyAndSellStockIV();
    System.out.println(s.maxProfit(2, new int[]{3,2,6,5,0,3}));
  }

  public int maxProfit(int k, int[] prices) {
    int[] prevSell = new int[k+1], prevBuy = new int[k+1];
    Arrays.fill(prevBuy, 0);
    Arrays.fill(prevSell, 0);

    for(int i = prices.length-1; i >= 0; --i){
      int[] curBuy = new int[k+1], curSell = new int[k+1];
      for(int capacity = 1; capacity <= k; ++capacity){
        curBuy[capacity] = Math.max(-prices[i]+prevSell[capacity], prevBuy[capacity]);
        curSell[capacity] = Math.max(prevSell[capacity], prices[i]+prevBuy[capacity-1]);
      }
      prevBuy = curBuy.clone();
      prevSell = curSell.clone();
    }
    return prevBuy[k];
  }
}
