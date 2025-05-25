package cp.dojo.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

  public static void main(String[] args){
    CombinationSumIII s = new CombinationSumIII();
    System.out.println(s.combinationSum3(3, 7));
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    if(k > n){
      return result;
    }
    backtrack(1, 0, result, new ArrayList<>(), k, n);
    return result;
  }

  private void backtrack(int index, int sum, List<List<Integer>> result, List<Integer> subList, int k, int n){
    if(subList.size() == k && sum == n){
      result.add(new ArrayList<>(subList));
      return;
    }
    for(int i = index; i <= 9; i += 1){
      int curTotal = sum + i;
      if(curTotal <= n){
        subList.add(i);
        backtrack(i+1, curTotal, result, subList, k, n);
        subList.removeLast();
      }
    }
  }
}
