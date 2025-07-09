
import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]

 *
 * SOLUTION APPROACH:
 * - Use string manipulation techniques
 * - Consider character counting, pattern matching, or parsing
 * - Handle edge cases like empty strings or special characters
 * - Use appropriate string methods efficiently
 *
 * TIME COMPLEXITY: Varies based on approach - typically O(n) to O(n²)
 * SPACE COMPLEXITY: Varies based on approach - typically O(1) to O(n)
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n²) or higher - Check all substrings
 * 2. Regular Expressions: O(n) - Use regex for pattern matching
 * 3. Character counting: O(n) - Count character frequencies
 *
 * KEY INSIGHTS:
 * - String operations can be optimized with appropriate data structures
 * - Consider character encoding and special cases
 * - Look for patterns that can be exploited
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }
    
    private void backtrack(List<List<String>> result, List<String> temp, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                backtrack(result, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
} 