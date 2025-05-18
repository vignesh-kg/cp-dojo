package cp.dojo.solution.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargetElement {

  public static void main(String[] args){
    KthLargetElement s = new KthLargetElement();
    System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    for(int num : nums){
      pq.offer(num);
    }
    for(int i = 1; i < k; i += 1){
      pq.poll();
    }
    return pq.poll();
  }
}
