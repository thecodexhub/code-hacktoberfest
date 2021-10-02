// Given an array with (n + 1) integers where each integer is between 1 to n (inclusive)
// Assume that there is only one duplicate number, find it.

// [https://www.youtube.com/watch?v=32Ll35mhWg0&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=2]

// Input: [1, 3, 4, 2, 2]
// Output: 2

// There is only one duplicate number, but it could be repeated more than once.

// LinkedList Cycle Method => Time complexity: O(N), Space complexity: O(1)

public class DuplicateNumber {

  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];

    // Tortoise method
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    nums[fast] = 0;

    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }
}
