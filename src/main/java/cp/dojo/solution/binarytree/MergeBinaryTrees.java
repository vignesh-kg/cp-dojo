package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class MergeBinaryTrees {
  public static void main(String[] args){
    TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
    TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
    MergeBinaryTrees s = new MergeBinaryTrees();
    TreeNode mergedTree = s.mergeTrees(root1, root2);
  }

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if(null == root1 && null == root2){
      return null;
    }

    if(root1 == null){
      return root2;
    } else if(root2 == null){
      return root1;
    }

    root1.val += root2.val;
    root1.left = mergeTrees(root1.left, root2.left);
    root1.right = mergeTrees(root1.right, root2.right);

    return root1;
  }
}
