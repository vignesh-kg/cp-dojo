package cp.dojo.solution.greedy;

public class JumpGame2 {

    public static void main(String[] args) {
        JumpGame2 s = new JumpGame2();
        System.out.println(s.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(s.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(s.jump(new int[]{0}));
        System.out.println(s.jump(new int[]{2, 0, 0}));
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumps = 0, left = 0, right = 0;
        while (right < nums.length-1){
            int farthest = 0;
            for(int index = left; index <= right; ++index){
                //farthest position that can be reached with current Jump
                farthest = Math.max(index+nums[index], farthest);
            }
            left = right+1;
            right = farthest;
            ++jumps;
        }
        return jumps;
    }
}