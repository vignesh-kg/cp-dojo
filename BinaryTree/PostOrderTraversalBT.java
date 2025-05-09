package BinaryTree;

import java.util.List;
import java.util.function.Consumer;
import java.util.ArrayList;

public class PostOrderTraversalBT {
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
    Consumer<TreeNode> dfs = new Consumer<TreeNode>(){
      @Override
      public void accept(TreeNode node){
        Consumer<TreeNode> recursiveDFS = this::accept;
        if(node == null) return;
        recursiveDFS.accept(node.left);
        recursiveDFS.accept(node.right);
        postOrder.add(node.val);
      }
    };
    dfs.accept(root);
    return postOrder;
  }
}