// Given an integer array, find the contiguous array (containing atleast one number)
// which has the largest sum and return the sum.

// [https://www.youtube.com/watch?v=w_KEocd__20&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=6]

// Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
// Output: 6
// Explanation: [4, -1, 2, 1] has the largest sum = 6

// Kadane's Algorithm => [Time Complexity: O(N)]

public class MaximumSubarray {

  public int maxSubArraySum(int[] nums) {
    // Take two variables => [max], [sum]
    // Iterate through the array, add the array[i] with the sum
    // If sum is greater than max, store it
    // If sum is less than 0, then re-assign sum to 0

    int max = nums[0];
    int sum = 0;

    for (int num : nums) {
      sum += num;
      if (sum > max) max = sum;
      if (sum < 0) sum = 0;
    }

    return max;
  }
}
