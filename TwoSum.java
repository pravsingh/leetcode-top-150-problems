
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * SOLUTION APPROACH:
 * - Use HashMap to store complements (target - current number)
 * - For each number, check if its complement exists in the map
 * - If found, return current index and complement's index
 * - If not found, store current number and its index
 *
 * TIME COMPLEXITY: O(n) - Single pass through the array
 * SPACE COMPLEXITY: O(n) - HashMap to store complements
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n²) time, O(1) space - Check all pairs
 * 2. Two Pointers: O(n log n) time, O(1) space - Sort first, then use two pointers
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
} 