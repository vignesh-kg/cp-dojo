package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class LongestZigZagPath {
  public static void main(String[] args){
    LongestZigZagPath s = new LongestZigZagPath();
    /*
     *      1
     * null   1
     *       1  1
     *         1  1
     *           1
     *             1
     *                1
     */
    TreeNode root = new TreeNode(1,
        null, new TreeNode(1,
        new TreeNode(1), new TreeNode(1,
        new TreeNode(1, new TreeNode(1, null, new TreeNode(1)), new TreeNode(1)), new TreeNode(1))));
    System.out.println(s.longestZigZag(root));
  }

  int maxLen = 0;

  public int longestZigZag(TreeNode root) {
    zigzagPath(root.left, 1, true);
    zigzagPath(root.right, 1, false);
    return maxLen;
  }

  private void zigzagPath(TreeNode node, int path, boolean isLeft){
    if(node == null){
      return;
    }
    maxLen = Math.max(maxLen, path);
    if(isLeft){
      zigzagPath(node.right, path+1, false);
      zigzagPath(node.left, 1, true);
    } else {
      zigzagPath(node.left, path+1, true);
      zigzagPath(node.right, 1, false);
    }
  }
}
