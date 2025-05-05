package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.IntStream;

public class CloneGraph {
  public static void main(String[] args) {
    Solution s = new Solution();
    Node head = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    head.neighbors.add(node4);
    head.neighbors.add(node2);
    node2.neighbors.add(head);
    node2.neighbors.add(node3);
    node3.neighbors.add(node4);
    node3.neighbors.add(node2);
    node4.neighbors.add(head);
    node4.neighbors.add(node3);
    Node copyNode = s.cloneGraph(head);
    System.out.println(head != copyNode);
  }
}

// Definition for a Node.
class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class Solution {
  public Node cloneGraph(Node node) {
    if (null == node)
      return node;

    Map<Node, Node> copyNodeMap = new HashMap<>();
    copyNodeMap.put(node, new Node(node.val));
    Queue<Node> q = new LinkedList<>();
    q.add(node);
    while (!q.isEmpty()) {
      int numberOfAdjNodes = q.size();
      for(int i = 0; i < numberOfAdjNodes; ++i) {
        Node currNode = q.poll();
        if (!copyNodeMap.containsKey(currNode)) {
          copyNodeMap.put(currNode, new Node(currNode.val));
        }
        Node copyCurrNode = copyNodeMap.get(currNode);
        for(Node childNode : currNode.neighbors){
          if (!copyNodeMap.containsKey(childNode)){
            copyNodeMap.put(childNode, new Node(childNode.val));
            q.add(childNode);
          }
          copyCurrNode.neighbors.add(copyNodeMap.get(childNode));
        }
      }
    }
    return copyNodeMap.get(node);
  }
}