
/**
 * 123. Best Time to Buy and Sell Stock III
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Example 1:
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
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
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0;
        int buy2 = Integer.MIN_VALUE, sell2 = 0;
        
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        
        return sell2;
    }
} 