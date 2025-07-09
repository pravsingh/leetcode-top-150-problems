
/**
 * 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: s = "race a car"
 * Output: false

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
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
} 