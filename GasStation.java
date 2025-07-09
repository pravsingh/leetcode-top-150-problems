
/**
 * 134. Gas Station
 *
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * Example 1:
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 *
 * Example 2:
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1

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
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int currentGas = 0, start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];
            
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }
        
        return totalGas >= totalCost ? start : -1;
    }
} 