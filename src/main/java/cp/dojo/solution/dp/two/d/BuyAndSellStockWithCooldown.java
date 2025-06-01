package cp.dojo.solution.dp.two.d;

public class BuyAndSellStockWithCooldown {
  public static void main(String[] args){
    BuyAndSellStockWithCooldown s = new BuyAndSellStockWithCooldown();
    System.out.println(s.maxProfit(new int[]{1,2,3,0,2}));
  }

  public int maxProfit(int[] prices) {
    int[] prevBuy = new int[prices.length+2], prevSell = new int[prices.length+2];
    for(int i = prices.length-1; i >= 0; --i){
      prevBuy[i] = Math.max(prevBuy[i+1], -prices[i]+prevSell[i+1]);
      prevSell[i] = Math.max(prevSell[i+1], prices[i]+prevBuy[i+2]);
    }
    return prevBuy[0];
  }
}
