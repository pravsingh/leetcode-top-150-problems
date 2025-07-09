
/**
 * 53. Maximum Subarray
 *
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * SOLUTION APPROACH:
 * - Use Kadane's algorithm (dynamic programming)
 * - Keep track of current sum and maximum sum seen so far
 * - For each element, decide whether to extend current subarray or start new one
 * - If current sum becomes negative, reset it to current element
 * - Update maximum sum whenever current sum exceeds it
 * - Return the maximum sum found
 *
 * TIME COMPLEXITY: O(n) - Single pass through the array
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. Divide and Conquer: O(n log n) - Split array and find max in left, right, and crossing
 * 2. Brute Force: O(n²) - Check all possible subarrays
 * 3. Prefix Sum: O(n) - Use prefix sums to calculate subarray sums
 *
 * KEY INSIGHTS:
 * - Kadane's algorithm is optimal for this problem
 * - Reset current sum when it becomes negative
 * - Handle edge case of all negative numbers
 * - Can be extended to find the actual subarray indices
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
} 