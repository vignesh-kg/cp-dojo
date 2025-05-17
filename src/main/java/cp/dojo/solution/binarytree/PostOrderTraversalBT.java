package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PostOrderTraversalBT {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    PostOrderTraversalBT s = new PostOrderTraversalBT();
    System.out.println(s.postorderTraversal(root));
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> postOrder = new ArrayList<>();
    Consumer<TreeNode> dfs = new Consumer<TreeNode>() {
      @Override
      public void accept(TreeNode node) {
        Consumer<TreeNode> recursiveDFS = this;
        if (node == null) return;
        recursiveDFS.accept(node.left);
        recursiveDFS.accept(node.right);
        postOrder.add(node.val);
      }
    };
    dfs.accept(root);
    return postOrder;
  }
}