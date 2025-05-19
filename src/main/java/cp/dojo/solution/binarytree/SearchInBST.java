package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class SearchInBST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
    SearchInBST s = new SearchInBST();
    System.out.println(s.searchBST(root, 2).val);
  }

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    } else if (root.val < val) {
      return searchBST(root.right, val);
    } else {
      return searchBST(root.left, val);
    }
  }
}
