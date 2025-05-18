package cp.dojo.solution.binarytree;
import java.util.List;
import java.util.ArrayList;
import cp.dojo.structure.TreeNode;

public class LeafSimilarTrees {
  public static void main(String[] args){
    LeafSimilarTrees s = new LeafSimilarTrees();
    TreeNode root1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(9), new TreeNode(8)));
    TreeNode root2 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(7)), new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))));
    System.out.println(s.leafSimilar(root1, root2));
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> tree1LeafNodes = new ArrayList<>();
    List<Integer> tree2LeafNodes = new ArrayList<>();
    collectLeafNodes(root1, tree1LeafNodes);
    collectLeafNodes(root2, tree2LeafNodes);
    return tree1LeafNodes.equals(tree2LeafNodes);
  }

  private void collectLeafNodes(TreeNode node, List<Integer> nodesList){
    if(node == null){
      return;
    }
    if(node.left == null && node.right == null){
      nodesList.add(node.val);
    } else {
      collectLeafNodes(node.left, nodesList);
      collectLeafNodes(node.right, nodesList);
    }
  }
}
