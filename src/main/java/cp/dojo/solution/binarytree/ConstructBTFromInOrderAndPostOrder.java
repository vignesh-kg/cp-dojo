package cp.dojo.solution.binarytree;

import cp.dojo.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInOrderAndPostOrder {
  public static void main(String[] args){
    ConstructBTFromInOrderAndPostOrder s = new ConstructBTFromInOrderAndPostOrder();
    System.out.println(s.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}).val);
  }
  Map<Integer, Integer> nodeToIndex = new HashMap<>();
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for(int i = 0; i < inorder.length; ++i){
      nodeToIndex.put(inorder[i], i);
    }
    return builder(0, 0, inorder.length-1, preorder, inorder );
  }

  private TreeNode builder(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
    if(preStart >= preorder.length || inStart > inEnd){
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int indexOfRootInInOrder = nodeToIndex.get(root.val);

    root.left = builder(preStart+1, inStart, indexOfRootInInOrder-1, preorder, inorder);
    root.right = builder(preStart+indexOfRootInInOrder-inStart+1, indexOfRootInInOrder+1, inEnd, preorder, inorder);
    return root;
  }
}
