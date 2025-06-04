package cp.dojo.solution.math;

public class ChildWithBallAfterKSec {
  public static void main(String[] args) {
    ChildWithBallAfterKSec s = new ChildWithBallAfterKSec();
    System.out.println(s.numberOfChild(5, 12));
    System.out.println(s.numberOfChild(3, 5));
  }

  public int numberOfChild(int n, int k) {
    /*
     * children ranging from 0 - (n-1)
     * Time required one round = 2(n-1)
     * if k > 2*(n-1) reduce k to single round
     * ex: n = 5 k = 12
     * when k = 10, ball will be back with child 0
     */
    if(k >= 2*(n-1)){
      k = k % (2*(n-1));
    }

    /*
     * if k < n, return k i.e, ball hasn't been revered yet
     * else ball will be with (n-1-k)th child
     */
    if(k >= n-1){
      k = k % (n-1);
      return n-1-k;
    }
    return k;
  }
}
