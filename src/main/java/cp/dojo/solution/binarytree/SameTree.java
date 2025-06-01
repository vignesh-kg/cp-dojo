package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class SameTree {
  public static void main(String[] args){
    SameTree s = new SameTree();
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(s.isSameTree(root, root));
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null){
      return true;
    }
    if(p == null || q == null){
      return false;
    }

    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
