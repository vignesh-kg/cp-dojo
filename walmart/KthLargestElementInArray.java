package walmart;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2))
    }

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue minHeap = new PriorityQueue<>();
            for(int num : nums){
                if(minHeap.size() < k){
                    minHeap.offer(num);
                } else if(num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
            return minHeap.peek();
        }
    }
}
