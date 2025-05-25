package cp.dojo.solution.binarytree;

import com.sun.source.tree.Tree;
import cp.dojo.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
  public static void main(String[] args){
    PathSumIII s = new PathSumIII();
    TreeNode root = new TreeNode(10, null, new TreeNode(-3, null, new TreeNode(11)));
    root.left = new TreeNode(5, null, new TreeNode(2, null, new TreeNode(1)));
    root.left.left = new TreeNode(3, new TreeNode(3), new TreeNode(-2));
    System.out.println(s.pathSum(root, 8));
  }

  Map<Long, Integer> diffMap;
  int paths;

  public int pathSum(TreeNode root, int targetSum) {
    diffMap = new HashMap<>();
    paths = 0;
    dfs(root, 0, targetSum);
    return paths;
  }

  private void dfs(TreeNode node, long prefixSum, int targetSum){
    if(node == null){
      return;
    }

    prefixSum += node.val;

    if(targetSum == prefixSum){
      paths += 1;
    }

    if(diffMap.containsKey(prefixSum-targetSum)){
      paths += diffMap.get(prefixSum-targetSum);
    }
    diffMap.put(prefixSum, diffMap.getOrDefault(prefixSum, 0)+1);
    dfs(node.left, prefixSum, targetSum);
    dfs(node.right, prefixSum, targetSum);
    diffMap.put(prefixSum, diffMap.get(prefixSum)-1);
  }
}
