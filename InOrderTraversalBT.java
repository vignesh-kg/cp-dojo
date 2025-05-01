import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.function.Consumer;
import java.util.function.Function;

public class InOrderTraversalBT {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    Solution s = new Solution();
    System.out.println(s.inorderTraversal(root));
  }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class InOrderTraversalTask extends RecursiveAction {

  private final TreeNode node;
  private final Consumer<Integer> inConsumer;

  public InOrderTraversalTask(TreeNode node, Consumer<Integer> inConsumer) {
    this.node = node;
    this.inConsumer = inConsumer;
  }

  @Override
  protected void compute() {
    if (node == null)
      return;

    List<RecursiveAction> subTasks = new ArrayList<>();
    subTasks.add(new InOrderTraversalTask(node.left, inConsumer));
    invokeAll(subTasks); // to process all left Sub Tree

    inConsumer.accept(node.val);

    subTasks = new ArrayList<>();
    subTasks.add(new InOrderTraversalTask(node.right, inConsumer));
    invokeAll(subTasks); // to Process all Right Sub Tree

  }
}

class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inOrder = new ArrayList<>();
    Consumer<Integer> inOrderConsumer = val -> {
      synchronized (inOrder) {
        inOrder.add(val);
      }
    };
    parallelDFS(root, inOrderConsumer);
    return inOrder;
  }

  private void parallelDFS(TreeNode root, Consumer<Integer> inConsumer) {
    if (root == null)
      return;
    ForkJoinPool forkJoinPool = new ForkJoinPool(4);
    try {
      forkJoinPool.invoke(new InOrderTraversalTask(root, inConsumer));
    } finally {
      forkJoinPool.close();
      forkJoinPool.shutdown();
    }

  }
}