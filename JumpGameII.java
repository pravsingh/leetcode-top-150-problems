
/**
 * 45. Jump Game II
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2

 *
 * SOLUTION APPROACH:
 * - Use appropriate array manipulation technique
 * - Consider sorting, two pointers, or sliding window
 * - Handle edge cases and boundary conditions
 * - Optimize for time and space complexity
 *
 * TIME COMPLEXITY: Varies based on approach - typically O(n) to O(n²)
 * SPACE COMPLEXITY: Varies based on approach - typically O(1) to O(n)
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n²) or higher - Check all combinations
 * 2. Sorting: O(n log n) - Sort first, then process
 * 3. Hash-based: O(n) - Use HashMap/HashSet for lookups
 *
 * KEY INSIGHTS:
 * - Choose the right data structure for the problem
 * - Consider trade-offs between time and space complexity
 * - Look for patterns that can be optimized
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, currentFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currentFarthest = Math.max(currentFarthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = currentFarthest;
            }
        }
        return jumps;
    }
} 