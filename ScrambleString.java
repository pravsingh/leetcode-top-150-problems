
import java.util.HashMap;
import java.util.Map;

/**
 * 87. Scramble String
 *
 * We can scramble a string s to get a string t using the following algorithm:
 * 1. If the length of the string is 1, stop.
 * 2. If the length of the string is > 1, do the following:
 *    Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
 *    Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
 *    Apply step 1 recursively on each of the two substrings x and y.
 *
 * Example 1:
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 *
 * Example 2:
 * Input: s1 = "abcde", s2 = "caebd"
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
public class ScrambleString {
    private Map<String, Boolean> memo = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) return memo.get(key);
        
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                memo.put(key, false);
                return false;
            }
        }
        
        for (int i = 1; i < s1.length(); i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && 
                 isScramble(s1.substring(i), s2.substring(i))) ||
                (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && 
                 isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))) {
                memo.put(key, true);
                return true;
            }
        }
        
        memo.put(key, false);
        return false;
    }
} 