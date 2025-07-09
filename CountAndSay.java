
/**
 * 38. Count and Say
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1)
 *
 * Example 1:
 * Input: n = 1
 * Output: "1"
 *
 * Example 2:
 * Input: n = 4
 * Output: "1211"

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
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;
        char current = prev.charAt(0);
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == current) {
                count++;
            } else {
                result.append(count).append(current);
                current = prev.charAt(i);
                count = 1;
            }
        }
        result.append(count).append(current);
        return result.toString();
    }
} 