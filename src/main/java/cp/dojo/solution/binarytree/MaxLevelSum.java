package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

  public static void main(String[] args) {
    MaxLevelSum s = new MaxLevelSum();
    TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
    System.out.println(s.maxLevelSum(root));
  }

  public int maxLevelSum(TreeNode root) {
    int maxLevel = 0;
    if (null == root)
      return maxLevel;
    Queue<TreeNode> q = new LinkedList<>();
    int maxSum = Integer.MIN_VALUE;
    int level = 0;
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      int curSum = 0;
      for (int i = 0; i < size; i += 1) {
        TreeNode curNode = q.poll();
        curSum += curNode.val;
        if (curNode.left != null)
          q.add(curNode.left);
        if (curNode.right != null)
          q.add(curNode.right);
      }
      level += 1;
      if (curSum > maxSum) {
        maxSum = curSum;
        maxLevel = level;
      }
    }
    return maxLevel;
  }
}