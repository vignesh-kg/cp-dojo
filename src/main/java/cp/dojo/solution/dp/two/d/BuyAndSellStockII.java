package cp.dojo.solution.dp.two.d;

public class BuyAndSellStockII {
  public static void main(String[] args){
    BuyAndSellStockII s = new BuyAndSellStockII();
    System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
  }

  public int maxProfit(int[] prices) {
    int prevBuy = 0, prevSell = 0;
    int curBuy = 0, curSell = 0;
    for(int i = prices.length-1; i >= 0; i -= 1){
      /*
       * Two Options: Either buy or not buy
       */
      curBuy = Math.max(-prices[i] + prevSell, prevBuy);
      /*
       * Two options: Either sell or don't sell
       */
      curSell = Math.max(prevSell, prices[i] + prevBuy);

      prevBuy = curBuy;
      prevSell = curSell;
    }
    return prevBuy;
  }
}
