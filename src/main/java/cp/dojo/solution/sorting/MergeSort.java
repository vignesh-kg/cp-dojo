package cp.dojo.solution.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
  public static void main(String[] args){
    MergeSort s = new MergeSort();
    int[] input = new int[]{10, 8, 15, 13, 99, 78, 67};
    s.sort(input);
    System.out.println(Arrays.toString(input));
  }

  public void sort(int[] nums){
    mergeSort(nums, 0, nums.length-1);
  }

  private void mergeSort(int[] nums, int low, int high){
    if(low < high){
      int mid = low + (high-low)/2;
      mergeSort(nums, low, mid);
      mergeSort(nums, mid+1, high);
      merge(nums, low, high, mid);
    }
  }

  private void merge(int[] nums, int low, int high, int mid){
    List<Integer> tempList = new ArrayList<>();
    int i = low, j = mid+1;
    while(i <= mid && j <= high){
      if(nums[i] <= nums[j]){
        tempList.add(nums[i]);
        ++i;
      } else {
        tempList.add(nums[j]);
        ++j;
      }
    }
    while(i <= mid){
      tempList.add(nums[i++]);
    }
    while(j <= high){
      tempList.add(nums[j++]);
    }

    for(int counter = low; counter <= high; ++counter){
      nums[counter] = tempList.get(counter-low);
    }
  }
}
