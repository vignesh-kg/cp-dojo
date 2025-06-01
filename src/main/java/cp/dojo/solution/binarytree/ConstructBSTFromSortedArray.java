package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class ConstructBSTFromSortedArray {
  public static void main(String[] args){
    ConstructBSTFromSortedArray s = new ConstructBSTFromSortedArray();
    TreeNode root = s.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    System.out.println(root.val);
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return construct(nums, 0, nums.length-1);
  }

  private TreeNode construct(int[] nums, int start, int end){
    if(start > end){
      return null;
    }
    int mid = start + (end-start)/2;
    return new TreeNode(nums[mid], construct(nums, start, mid-1), construct(nums, mid+1,end ));
  }
}
