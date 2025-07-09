
import java.util.*;

/**
 * 15. 3Sum
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j != k and nums[i] + nums[j] + nums[k] == 0.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 * SOLUTION APPROACH:
 * - Sort the array first to enable two-pointer technique
 * - Use three pointers: i (fixed), left, and right
 * - For each i, use two pointers to find pairs that sum to -nums[i]
 * - Skip duplicates to avoid duplicate triplets
 * - Handle edge cases like empty array and insufficient elements
 *
 * TIME COMPLEXITY: O(n²) - O(n log n) for sorting + O(n²) for two-pointer search
 * SPACE COMPLEXITY: O(1) - Constant extra space (excluding output)
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n³) - Check all triplets
 * 2. Hash-based: O(n²) - Use HashMap to store complements
 * 3. Recursive: O(n³) - Backtracking approach
 *
 * KEY INSIGHTS:
 * - Sorting enables two-pointer technique and duplicate skipping
 * - Skip duplicates at each level (i, left, right) to avoid duplicate results
 * - Two-pointer technique reduces complexity from O(n³) to O(n²)
 * - Handle edge cases: array length < 3, all zeros, etc.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++; right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
} 