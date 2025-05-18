package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class CountGoodNodes {
  public static void main(String[] args){
    CountGoodNodes s = new CountGoodNodes();
    TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
    System.out.println(s.goodNodes(root));
  }

  public int goodNodes(TreeNode root) {
    int prev = root.val;
    return countGoodNode(root, prev);
  }

  private int countGoodNode(TreeNode node, int prev){
    if(node == null){
      return 0;
    }
    if(node.val >= prev){
      return 1 + countGoodNode(node.left, node.val) + countGoodNode(node.right, node.val);
    }

    return countGoodNode(node.left, prev) + countGoodNode(node.right, prev);
  }
}
