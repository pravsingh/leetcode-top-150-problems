
import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 *
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]

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
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }
    
    private void backtrack(List<String> result, List<String> temp, String s, int start) {
        if (temp.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", temp));
            }
            return;
        }
        
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String segment = s.substring(start, start + i);
            if (isValid(segment)) {
                temp.add(segment);
                backtrack(result, temp, s, start + i);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') return false;
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
} 