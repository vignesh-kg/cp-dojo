package BinaryTree;

import java.util.List;
import java.util.ArrayList;

public class PreOrderTraversalBT {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    Solution s = new Solution();
    System.out.println(s.postorderTraversal(root));
  }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> postOrder = new ArrayList<>();
	  dfs(root, postOrder);
	  return postOrder;	 
    }
	
	private void dfs(TreeNode root, List<Integer> postOrder){
	  if(root == null) return;
	  
	  dfs(root.left, postOrder);
	  dfs(root.right, postOrder);
	  postOrder.add(root.val);
	}
}