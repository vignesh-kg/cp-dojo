package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PreOrderTraversalBT {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    PreOrderTraversalBT s = new PreOrderTraversalBT();
    System.out.println(s.preorderTraversal(root));
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preOrder = new ArrayList<>();
    Consumer<TreeNode> dfs = new Consumer<TreeNode>() {
      @Override
      public void accept(TreeNode node) {
        Consumer<TreeNode> recursiveDFS = this;
        if (node == null) return;
        preOrder.add(node.val);
        recursiveDFS.accept(node.left);
        recursiveDFS.accept(node.right);
      }

    };
    dfs.accept(root);
    return preOrder;
  }
}
