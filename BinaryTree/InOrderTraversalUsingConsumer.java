package BinaryTree;

import java.util.List;
import java.util.function.Consumer;
import java.util.ArrayList;

public class InOrderTraversalUsingConsumer {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    Solution s = new Solution();
    System.out.println(s.inorderTraversal(root));
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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inOrder = new ArrayList<>();
    Consumer<TreeNode> dfs = new Consumer<TreeNode>() {
      @Override
      public void accept(TreeNode node){
        if(node == null) return;
        Consumer<TreeNode> recursiveDFS = this::accept;
        recursiveDFS.accept(node.left);
        inOrder.add(node.val);
        recursiveDFS.accept(node.right);
      }
    };
    dfs.accept(root);
    return inOrder;
  }
}