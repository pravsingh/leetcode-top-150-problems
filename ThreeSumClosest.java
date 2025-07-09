
import java.util.Arrays;

/**
 * 16. 3Sum Closest
 *
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 *
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 *
 * SOLUTION APPROACH:
 * - Sort the array first to enable two-pointer technique
 * - Use three pointers: i (fixed), left, and right
 * - For each i, use two pointers to find closest sum to target
 * - Keep track of the closest sum found so far
 * - Update closest sum when we find a better approximation
 * - Handle edge cases and early termination
 *
 * TIME COMPLEXITY: O(n²) - O(n log n) for sorting + O(n²) for two-pointer search
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n³) - Check all triplets
 * 2. Hash-based: O(n²) - Use HashMap to store complements
 * 3. Recursive: O(n³) - Backtracking approach
 *
 * KEY INSIGHTS:
 * - Similar to 3Sum but track closest instead of exact matches
 * - Sorting enables two-pointer technique
 * - Update closest sum whenever we find a better approximation
 * - Can optimize by skipping duplicates like in 3Sum
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum; // Exact match found
                }
            }
        }
        
        return closestSum;
    }
} 