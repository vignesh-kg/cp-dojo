package cp.dojo.solution.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class CourseScheduleUsingBFS {
  public static void main(String[] args) {
    CourseScheduleUsingBFS s = new CourseScheduleUsingBFS();
    System.out.println(s.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses == 1) return true;

    List<List<Integer>> adjacencyList = new ArrayList<>();
    IntStream.range(0, numCourses).forEach(_ -> adjacencyList.add(new ArrayList<>()));
    int[] indegrees = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      adjacencyList.get(prerequisite[0]).add(prerequisite[1]);
      indegrees[prerequisite[1]] += 1;
    }
    Queue<Integer> q = new LinkedList<>();
    IntStream.range(0, numCourses).forEach(i -> {
      if (indegrees[i] == 0) q.add(i);
    });
    List<Integer> topoSort = new ArrayList<>();
    while (!q.isEmpty()) {
      int node = q.poll();
      topoSort.add(node);
      for (int neighbourNode : adjacencyList.get(node)) {
        indegrees[neighbourNode] -= 1;
        if (indegrees[neighbourNode] == 0) q.add(neighbourNode);
      }
    }
    return topoSort.size() == numCourses;
  }
}