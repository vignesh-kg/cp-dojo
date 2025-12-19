import java.util.List;
import java.util.ArrayList;

public class CombinationSum{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.combinationSum(new int[]{2,3,6,7}, 7));
	}
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
		backtrack(0, res, new ArrayList<>(), 0, target, candidates);
		return res;
    }
	
	private void backtrack(int index, List<List<Integer>> res, List<Integer> temp, int curSum, int target, int[] candidates){
		if(curSum == target){
			res.add(new ArrayList<>(temp));
			return;
		}
		
		if(index >= candidates.length || curSum > target){
			return;
		}
		
		if(candidates[index] <= target){
			temp.add(candidates[index]);
			backtrack(index, res, temp, curSum + candidates[index], target, candidates);
			temp.remove(temp.size()-1);
		}
		backtrack(index+1, res, temp, curSum, target, candidates);
	}
}
