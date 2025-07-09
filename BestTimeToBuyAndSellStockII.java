
/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 *
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4

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
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
} 