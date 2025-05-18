package cp.dojo.solution.monotonic.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
  public static void main(String[] args){
    StockSpanner stockSpanner = new StockSpanner();
    System.out.println(stockSpanner.next(100));
    System.out.println(stockSpanner.next(80));
    System.out.println(stockSpanner.next(60));
    System.out.println(stockSpanner.next(70));
    System.out.println(stockSpanner.next(60));
    System.out.println(stockSpanner.next(75));
    System.out.println(stockSpanner.next(85));
  }
}

class Pair{
  int price;
  int span;

  Pair(int price,int span){
    this.price = price;
    this.span = span;
  }
}

class StockSpanner {
  Deque<Pair> stack;
  public StockSpanner() {
    stack = new ArrayDeque<>();
  }

  public int next(int price) {
    int span = 1;
    while(!stack.isEmpty() && stack.peek().price <= price){
      span += stack.pop().span;
    }
    stack.push(new Pair(price, span));
    return span;
  }
}