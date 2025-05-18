package cp.dojo.solution.greedy;

public class BuyAndSellStock {
  public static void main(String[] args) {
    BuyAndSellStock s = new BuyAndSellStock();
    System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
  }

  public int maxProfit(int[] prices) {
    int maxProfit = Integer.MIN_VALUE, minBuyingPrice = Integer.MAX_VALUE;
    for(int price : prices){
      if(minBuyingPrice > price){
        minBuyingPrice = price;
      }
      if(maxProfit < price-minBuyingPrice){
        maxProfit = price-minBuyingPrice;
      }
    }
    return maxProfit;
  }
}
