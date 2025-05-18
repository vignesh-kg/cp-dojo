package cp.dojo.solution.dp.two.d;

public class BuyAndSellStockWithFee {

  public static void main(String[] args){
    BuyAndSellStockWithFee s = new BuyAndSellStockWithFee();
    System.out.println(s.maxProfit(new int[]{1,3,2,8,4,9}, 2));
  }

  public int maxProfit(int[] prices, int fee) {
    int prevBuy = 0, prevSell = 0;
    int curBuy = 0, curSell = 0;
    for(int i = prices.length-1; i >= 0; i -= 1){
      curBuy = Math.max(-prices[i]+prevSell, prevBuy);
      curSell = Math.max(prices[i] + prevBuy-fee, prevSell);

      prevBuy = curBuy;
      prevSell = curSell;
    }
    return prevBuy;
  }
}
