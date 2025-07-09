
/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 *
 * SOLUTION APPROACH:
 * - Use vertical scanning (character by character comparison)
 * - Compare characters at the same position across all strings
 * - Stop when characters don't match or string ends
 * - Return the common prefix found so far
 * - Handle edge cases: empty array, single string, empty strings
 * - Use the first string as reference for length
 *
 * TIME COMPLEXITY: O(S) where S is the sum of all characters in all strings
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. Horizontal scanning: O(S) time, O(1) space - Compare strings pairwise
 * 2. Divide and conquer: O(S) time, O(m log n) space - Recursive approach
 * 3. Binary search: O(S log m) time, O(1) space - Binary search on prefix length
 *
 * KEY INSIGHTS:
 * - Vertical scanning is most intuitive and efficient
 * - Stop at first mismatch or when any string ends
 * - Can optimize by finding shortest string first
 * - Handle edge cases carefully (empty strings, single string)
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Use first string as reference
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            // Compare with other strings
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        return strs[0];
    }
} 