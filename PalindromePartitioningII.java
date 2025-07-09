
/**
 * 132. Palindrome Partitioning II
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: 1
 *
 * Example 2:
 * Input: s = "a"
 * Output: 0

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
public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] cuts = new int[n];
        
        for (int i = 0; i < n; i++) {
            int minCuts = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    minCuts = j == 0 ? 0 : Math.min(minCuts, cuts[j - 1] + 1);
                }
            }
            cuts[i] = minCuts;
        }
        
        return cuts[n - 1];
    }
} 