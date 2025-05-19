package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

public class DeleteNodeInBST {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5,
        new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
    DeleteNodeInBST s = new DeleteNodeInBST();
    System.out.println(s.deleteNode(root, 3).val);
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (root.val == key) {
      /*
       * Since right subTree is null, root of left subTree will be the new root.
       * Hence, return left subTree
       */
      if (root.right == null) {
        return root.left;
      }
      /*
       * Since left subTree is null, root of right subTree will be the new root.
       * Hence, return right subTree
       */
      else if (root.left == null) {
        return root.right;
      }
      /*
       * Since both left and right subTrees are not null, we need to find new root.
       * To keep the tree balanced, we will find the left most node of right Subtree,
       * so any values on the left subtree will be lesser than the new root
       * and any values on the right subTree will be greater than new root.
       *
       * Since, left most node of right subTree is new root, delete the node from subTree
       */
      else {
        TreeNode leftMostNodeOfRightSubTree = findLeftMostOfRightTree(root.right);
        root.val = leftMostNodeOfRightSubTree.val;
        root.right = deleteNode(root.right, root.val);
      }
    } else {
      /*
       * If key is in right Sub Tree i.e root is smaller than key, delete node from right subTree
       * and assign new root as right sub Tree
       */
      if (root.val < key) {
        root.right = deleteNode(root.right, key);
      }
      /*
       * If key is in left Sub Tree i.e root is greater than key, delete node from left subTree
       * and assign new root as left sub Tree
       */
      else {
        root.left = deleteNode(root.left, key);
      }
    }
    return root;
  }

  private TreeNode findLeftMostOfRightTree(TreeNode node) {
    if (node.left == null) {
      return node;
    }
    return findLeftMostOfRightTree(node.left);
  }
}
