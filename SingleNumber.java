
/**
 * 136. Single Number
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * SOLUTION APPROACH:
 * - Use XOR (exclusive or) operation
 * - XOR has properties: a ^ a = 0, a ^ 0 = a, a ^ b ^ a = b
 * - XOR all numbers in the array
 * - Pairs of same numbers will cancel out (become 0)
 * - Single number will remain as the result
 * - This works because XOR is associative and commutative
 *
 * TIME COMPLEXITY: O(n) - Single pass through the array
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. HashSet: O(n) time, O(n) space - Track seen numbers
 * 2. Sorting: O(n log n) time, O(1) space - Sort and find single
 * 3. Math: O(n) time, O(n) space - Use sum formula
 *
 * KEY INSIGHTS:
 * - XOR is perfect for finding single element among pairs
 * - No need for extra data structures
 * - Works with any number of duplicates (as long as one is single)
 * - Can be extended to find two single numbers
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
} 