package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class SymmetricTree {
  public static void main(String[] args) {
    SymmetricTree s = new SymmetricTree();
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
    System.out.println(s.isSymmetric(root));
  }

  public boolean isSymmetric(TreeNode root) {
    if (root.left == null && root.right == null) {
      return true;
    }
    if (root.left == null || root.right == null) {
      return false;
    }
    return isSame(root.left, root.right);
  }

  private boolean isSame(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }

    return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
  }
}
