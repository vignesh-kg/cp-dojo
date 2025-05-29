package cp.dojo.solution.graph;

import java.util.*;

public class CourseScheduleII {
  public static void main(String[] args) {
    CourseScheduleII s = new CourseScheduleII();
    int[][] prerequisites = new int[][]{{1,0}};
    System.out.println(Arrays.toString(s.findOrder(2, prerequisites)));
    prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
    System.out.println(Arrays.toString(s.findOrder(4, prerequisites)));
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjList = new ArrayList<>();
    for(int i = 0; i < numCourses; ++i){
      adjList.add(new ArrayList<>());
    }
    int[] inDegree = new int[numCourses];
    for(int[] prereq : prerequisites){
      adjList.get(prereq[1]).add(prereq[0]);
      ++inDegree[prereq[0]];
    }
    Deque<Integer> queue = new ArrayDeque<>();
    int[] result = new int[numCourses];
    int index = 0;
    for(int i = 0; i < inDegree.length; ++i){
      if(inDegree[i] == 0){
        queue.offer(i);
      }
    }
    while(!queue.isEmpty()){
      int cur = queue.poll();
      result[index++] = cur;
      for(int nextCourse : adjList.get(cur)){
        --inDegree[nextCourse];
        if(inDegree[nextCourse] == 0){
          queue.offer(nextCourse);
        }
      }
    }
    return index == numCourses ? result : new int[0];
  }
}
