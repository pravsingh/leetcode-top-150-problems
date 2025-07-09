
/**
 * 65. Valid Number
 *
 * A valid number can be split up into these components (in order):
 * 1. A decimal number or an integer.
 * 2. (Optional) An 'e' or 'E', followed by an integer.
 *
 * Example 1:
 * Input: s = "0"
 * Output: true
 *
 * Example 2:
 * Input: s = "e"
 * Output: false

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
public class ValidNumber {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == 'e' || c == 'E') {
                if (seenExponent || !seenDigit) return false;
                seenExponent = true;
                seenDigit = false;
            } else if (c == '.') {
                if (seenDot || seenExponent) return false;
                seenDot = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else {
                return false;
            }
        }
        return seenDigit;
    }
} 