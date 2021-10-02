// Given a collection of intervals. Merge all overlapping intervals

// [https://www.youtube.com/watch?v=2JzRBPFYbKE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=7]

// Input: [[1, 3], [2, 6], [8, 10], [15, 18]]
// Output: [[1, 6], [8, 10], [15, 18]]
// Explanation: Since intervals [1, 3] and [2, 6] overlaps, merge them to [1, 6]

// ?Given intervals might not be sorted --> Confirm it!

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    ArrayList<int[]> result = new ArrayList<>();

    // Check if the intervals array is null, then return null array
    if (intervals.length == 0) {
      return result.toArray(new int[0][]);
    }

    // ***** Sort the intervals array ***** --> Not necessay if given intervals are sorted
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // [start], [end] is initialised with the lower and upper bound of first element
    int start = intervals[0][0];
    int end = intervals[0][1];

    // Iterate over the intervals
    for (int[] i : intervals) {
      // If the lower bound is less than the end => they are overlapping
      // Compare the end values and re-assign it.
      if (i[0] <= end) {
        end = Math.max(i[1], end);
      }
      // Else => they are not overlapping
      // Add the start and end point to the result
      // Re-assign the start and end point
      else {
        result.add(new int[] { start, end });
        start = i[0];
        end = i[1];
      }
    }

    // At the end of the iteration whatever is left in start and end
    // Add them to the result and resturn it.
    result.add(new int[] { start, end });
    return result.toArray(new int[0][]);
  }
}
