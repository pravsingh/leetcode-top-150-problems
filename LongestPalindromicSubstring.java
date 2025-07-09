
/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * SOLUTION APPROACH:
 * - Use expand around center technique
 * - For each position, expand as far as possible in both directions
 * - Handle both odd-length (single character center) and even-length (two character center) palindromes
 * - Keep track of the longest palindrome found so far
 * - Return the substring with maximum length
 *
 * TIME COMPLEXITY: O(n²) - For each center, we expand up to O(n) times
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. Dynamic Programming: O(n²) time, O(n²) space - Build DP table
 * 2. Manacher's Algorithm: O(n) time, O(n) space - Linear time algorithm
 * 3. Brute Force: O(n³) time, O(1) space - Check all substrings
 *
 * KEY INSIGHTS:
 * - Expand around center is more efficient than checking all substrings
 * - Need to handle both odd and even length palindromes
 * - Center can be a single character or between two characters
 * - Update start and length when we find a longer palindrome
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        
        int start = 0, maxLength = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // Check odd-length palindromes (single character center)
            int len1 = expandAroundCenter(s, i, i);
            // Check even-length palindromes (two character center)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int currentMax = Math.max(len1, len2);
            
            if (currentMax > maxLength) {
                start = i - (currentMax - 1) / 2;
                maxLength = currentMax;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
} 