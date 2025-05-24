package cp.dojo.solution.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffOfTwoArrays {
  public static void main(String[] args){
    DiffOfTwoArrays s = new DiffOfTwoArrays();
    List<List<Integer>> diff = s.findDifference(new int[]{1,2,3}, new int[]{2,4,6});
    for(List<Integer> res : diff){
      System.out.println(res);
    }
  }

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    List<List<Integer>> result = new ArrayList<>();
    int[] count1 = new int[2001];
    for(int num : nums1){
      count1[num + 1000] += 1;
    }
    int[] count2 = new int[2001];
    for(int num : nums2){
      count2[num + 1000] += 1;
    }
    Set<Integer> res1 = new HashSet<>();
    Set<Integer> res2 = new HashSet<>();
    for(int num2 : nums2){
      if(count1[num2+1000] == 0){
        res1.add(num2);
      }
    }
    for(int num1 : nums1){
      if(count2[num1+1000] == 0){
        res2.add(num1);
      }
    }
    result.add(new ArrayList<>(res2));
    result.add(new ArrayList<>(res1));
    return result;
  }
}
