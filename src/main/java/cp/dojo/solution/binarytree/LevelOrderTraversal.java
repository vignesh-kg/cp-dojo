package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderTraversal {
  public static void main(String[] args){
    LevelOrderTraversal s = new LevelOrderTraversal();
    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    for(List<Integer> level : s.levelOrder(root)){
      System.out.println(level);
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null){
      return result;
    }
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while(!queue.isEmpty()){
      int n = queue.size();
      List<Integer> levelRes = new ArrayList<>();
      for(int i = 0; i < n; ++i){
        TreeNode cur = queue.poll();
        levelRes.add(cur.val);
        if(cur.left != null){
          queue.add(cur.left);
        }
        if(cur.right != null){
          queue.add(cur.right);
        }
      }
      result.add(levelRes);
    }
    return result;
  }
}
