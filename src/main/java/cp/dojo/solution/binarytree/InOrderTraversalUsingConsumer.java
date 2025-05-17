package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class InOrderTraversalUsingConsumer {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    InOrderTraversalUsingConsumer s = new InOrderTraversalUsingConsumer();
    System.out.println(s.inorderTraversal(root));
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inOrder = new ArrayList<>();
    Consumer<TreeNode> dfs = new Consumer<TreeNode>() {
      @Override
      public void accept(TreeNode node) {
        if (node == null) return;
        Consumer<TreeNode> recursiveDFS = this;
        recursiveDFS.accept(node.left);
        inOrder.add(node.val);
        recursiveDFS.accept(node.right);
      }
    };
    dfs.accept(root);
    return inOrder;
  }
}