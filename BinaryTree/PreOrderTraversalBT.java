package BinaryTree;
import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalBT {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    Solution s = new Solution();
    System.out.println(s.preorderTraversal(root));
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
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preOrder = new ArrayList<>();
    dfs(root, preOrder);
    return preOrder;
  }

  private void dfs(TreeNode root, List<Integer> preOrder){
    if(root == null) return;
    preOrder.add(root.val);
    dfs(root.left, preOrder);
    dfs(root.right, preOrder);
  }
}