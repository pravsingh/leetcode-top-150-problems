
import java.util.*;

/**
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * Example 1:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 *
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]

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
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int start, int n, int k) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(result, temp, i + 1, n, k);
            temp.remove(temp.size() - 1);
        }
    }
} 