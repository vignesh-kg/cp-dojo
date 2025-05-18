package cp.dojo.solution.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {

  public static void main(String[] args) {
    NonOverlappingIntervals s = new NonOverlappingIntervals();
    System.out.println(s.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    System.out.println(s.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
    System.out.println(s.eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}));

  }

  public int eraseOverlapIntervals(int[][] intervals) {
    /*
     * Sort Intervals by endTime
     */
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
    int overlappingIntervals = 0;
    int prevEndTime = intervals[0][1];
    for (int i = 1; i < intervals.length; i += 1) {
      /*
       * If prev Interval's End time is > current Interval's start time
       * there is an overlapping interval
       */
      if (prevEndTime > intervals[i][0]) {
        overlappingIntervals += 1;
        /*
         * Update prev Interval's end time with min(prev Interval's end time, cur Interval's end time)
         */
        prevEndTime = Math.min(prevEndTime, intervals[i][1]);
      } else {
        prevEndTime = intervals[i][1];
      }
    }
    return overlappingIntervals;
  }
}
