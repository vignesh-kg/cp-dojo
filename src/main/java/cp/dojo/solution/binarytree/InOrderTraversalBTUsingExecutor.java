package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class InOrderTraversalBTUsingExecutor {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    InOrderTraversalBTUsingExecutor s = new InOrderTraversalBTUsingExecutor();
    System.out.println(s.inorderTraversal(root));
  }

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
    ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    try {
      List<Future> futures = new ArrayList<>();
      futures.add(CompletableFuture.runAsync(() -> parallelDFS(root.left, inConsumer), executor));
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
      inConsumer.accept(root.val);
      futures = new ArrayList<>();
      futures.add(CompletableFuture.runAsync(() -> parallelDFS(root.right, inConsumer), executor));
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

      executor.close();
      executor.shutdown();
      executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}