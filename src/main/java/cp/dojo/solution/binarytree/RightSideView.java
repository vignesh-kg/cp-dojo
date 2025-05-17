package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
  public static void main(String[] args) {
    RightSideView s = new RightSideView();
    TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
    System.out.println(s.rightSideView(root));
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (null == root)
      return res;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      int rightVal = -1;
      for (int i = 0; i < size; i += 1) {
        TreeNode curTreeNode = q.poll();
        rightVal = curTreeNode.val;
        if (curTreeNode.left != null)
          q.add(curTreeNode.left);
        if (curTreeNode.right != null)
          q.add(curTreeNode.right);
      }
      res.add(rightVal);
    }
    return res;
  }
}
