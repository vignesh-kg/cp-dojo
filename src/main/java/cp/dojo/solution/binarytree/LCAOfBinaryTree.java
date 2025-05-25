package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class LCAOfBinaryTree {
  public static void main(String[] args) {
    LCAOfBinaryTree s = new LCAOfBinaryTree();
    TreeNode root = new TreeNode(3);
    TreeNode left = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
    TreeNode right = new TreeNode(1, new TreeNode(0), new TreeNode(8));
    root.left = left;
    root.right = right;
    System.out.println(s.lowestCommonAncestor(root, left, right).val);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || q == root) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left == null) {
      return right;
    } else if (right == null) {
      return left;
    } else {
      return root;
    }
  }
}
