
import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 *
 * SOLUTION APPROACH:
 * - Use sliding window technique with HashMap
 * - Maintain a window with unique characters
 * - When we encounter a repeating character, shrink window from left
 * - Keep track of maximum window size seen so far
 * - Use HashMap to store character positions for O(1) lookup
 *
 * TIME COMPLEXITY: O(n) - Single pass through the string
 * SPACE COMPLEXITY: O(min(m, n)) where m is the size of the charset
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n³) - Check all substrings
 * 2. HashSet: O(n) - Similar approach but with HashSet
 * 3. Array: O(n) - Use fixed-size array for ASCII characters
 *
 * KEY INSIGHTS:
 * - Sliding window is optimal for substring problems
 * - HashMap provides O(1) character position lookup
 * - Window shrinking ensures we don't miss optimal solutions
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }
            
            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
} 