public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnes s = new MaxConsecutiveOnes();
        System.out.println(s.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0, curOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                ++curOnes;
            } else {
                if (maxConsecutiveOnes < curOnes) {
                    maxConsecutiveOnes = curOnes;
                }
                curOnes = 0;
            }
        }
        return maxConsecutiveOnes < curOnes ? curOnes : maxConsecutiveOnes;
    }
}
