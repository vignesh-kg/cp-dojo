package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
    }
}

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetsList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, subsetsList, new ArrayList<>(), false);
        return subsetsList;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> subsetList, List<Integer> subset, boolean isElementNotPicked) {
        if (index == nums.length) {
            subsetList.add(new ArrayList<>(subset));
            return;
        }

        if (index == 0 || nums[index] != nums[index - 1] || isElementNotPicked) {
            subset.add(nums[index]);
            backtrack(index + 1, nums, subsetList, subset, true);
            subset.remove(subset.size() - 1);  
        }
        backtrack(index + 1, nums, subsetList, subset, false);
    }
}
