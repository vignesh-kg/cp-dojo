package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
    Consumer<TreeNode> dfs = new Consumer<TreeNode>() {
      @Override
      public void accept(TreeNode node) {
        Consumer<TreeNode> recursiveDFS = this::accept;
        if (node == null)
          return;
        preOrder.add(node.val);
        recursiveDFS.accept(node.left);
        recursiveDFS.accept(node.right);
      }

    };
    dfs.accept(root);
    return preOrder;
  }
}