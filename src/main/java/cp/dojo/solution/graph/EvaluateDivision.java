package cp.dojo.solution.graph;

import java.util.*;

public class EvaluateDivision {

  public static void main(String[] args) {
    EvaluateDivision s = new EvaluateDivision();
    List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
    System.out.println(Arrays.toString(s.calcEquation(List.of(List.of("a", "b"), List.of("b", "c")), new double[]{2.0, 3.0}, queries)));
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<Node>> adjMatrix = new HashMap<>();
    /*
     * Convert Equations to graph where Numerator is source Node and denominator is target Node
     * and equation is weight
     * from given equation a/b = 2.0, we have two edges a/b = 2.0 and b/a = 1/2.0
     */
    for (int i = 0; i < equations.size(); i += 1) {
      List<String> edge = equations.get(i);
      if (!adjMatrix.containsKey(edge.get(0))) {
        adjMatrix.put(edge.getFirst(), new ArrayList<>());
      }
      if (!adjMatrix.containsKey(edge.get(1))) {
        adjMatrix.put(edge.getLast(), new ArrayList<>());
      }
      adjMatrix.get(edge.getFirst()).add(new Node(edge.getLast(), values[i]));
      adjMatrix.get(edge.getLast()).add(new Node(edge.getFirst(), 1 / values[i]));
    }

    double[] res = new double[queries.size()];
    for (int i = 0; i < queries.size(); i += 1) {
      List<String> query = queries.get(i);
      /*
       * If no equation given for numerator or denominator, return -1.0
       */
      if (!adjMatrix.containsKey(query.getFirst()) || !adjMatrix.containsKey(query.getLast())) {
        res[i] = -1.0;
      } else {
        /*
         * run DFS with Numerator as source and denominator as target.
         * Multiply the edges as we traverse
         */
        res[i] = dfs(adjMatrix, query.getFirst(), query.getLast(), new HashSet<>(), 1.0);
      }
    }
    return res;
  }

  private double dfs(Map<String, List<Node>> adjMatrix, String source, String target, Set<String> visited, double product) {
    visited.add(source);
    for (Node node : adjMatrix.get(source)) {
      if (node.node.equals(target)) {
        return product * node.weight;
      }
      if (!visited.contains(node.node)) {
        double result = dfs(adjMatrix, node.node, target, visited, product * node.weight);
        if (result != -1.0) {
          return result;
        }
      }
    }
    return -1.0;
  }
}

class Node {
  String node;
  double weight;

  Node(String node, double weight) {
    this.node = node;
    this.weight = weight;
  }
}