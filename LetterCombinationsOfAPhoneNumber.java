
import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []

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
public class LetterCombinationsOfAPhoneNumber {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    private void backtrack(List<String> result, StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(result, sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
} 