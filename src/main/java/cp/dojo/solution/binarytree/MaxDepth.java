package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class MaxDepth {
  public static void main(String[] args){
    MaxDepth s = new MaxDepth();
    System.out.println(s.maxDepth(new TreeNode(3,
        new TreeNode(9),new TreeNode(20, new TreeNode(15),new TreeNode(7)))));
  }

  public int maxDepth(TreeNode root) {
    if(null == root){
      return 0;
    }

    int lh = maxDepth(root.left);
    int rh = maxDepth(root.right);

    return 1 + Math.max(lh, rh);
  }
}
