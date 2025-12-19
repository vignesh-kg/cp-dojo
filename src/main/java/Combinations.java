import java.util.List;
import java.util.ArrayList;

public class Combinations{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.combine(4, 2));
	}
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), 1, k, n);
		return res;
    }
	
	private void backtrack(List<List<Integer>> res, List<Integer> temp, int index, int size, int limit){
		if(temp.size() == size){
			res.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i = index; i <= limit; ++i){
			temp.add(i);
			backtrack(res, temp, i+1, size, limit);
			temp.remove(temp.size()-1);
		}
	}
}
