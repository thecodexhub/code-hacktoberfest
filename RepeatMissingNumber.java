// Find the repeating and the missing number

// [https://www.youtube.com/watch?v=5nMGY4VUoRY&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=3]

// Input: [1, 3, 4, 2, 6, 1]
// Output: Repeat: 1, Missing: 5

public class RepeatMissingNumber {

  public void getTwoElements(int[] nums) {
    int xor = 0;

    // XOR of all the elements in the array => xor
    for (int i = 0; i < nums.length; i++) {
      xor = xor ^ nums[i];
    }

    // xor ^ (all the numbers from 1 to n) => missing ^ repeating = xor
    for (int i = 1; i <= nums.length; i++) {
      xor = xor ^ i;
    }

    // Get the rightmost set-bit => xor & ~(xor - 1)
    int set_bit = xor & ~(xor - 1);

    // make two baskets: x and y
    int x = 0, y = 0;

    // Traverse all the elements in the array => if i-th element (a[i] & set-bit) != 0
    // XOR it with x otherwise XOR it with y
    for (int i = 0; i < nums.length; i++) {
      if ((nums[i] & set_bit) != 0) {
        x = x ^ nums[i];
      } else {
        y = y ^ nums[i];
      }
    }

    // Repeat the same with elements from 1 to n
    for (int i = 1; i <= nums.length; i++) {
      if ((i & set_bit) != 0) {
        x = x ^ i;
      } else {
        y = y ^ i;
      }
    }
    //* x => missing, y => repeating
  }
}
