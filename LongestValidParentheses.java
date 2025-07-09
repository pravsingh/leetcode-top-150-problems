
import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 *
 * Example 2:
 * Input: s = ")()())"
 * Output: 4

 *
 * SOLUTION APPROACH:
 * - Identify optimal substructure and overlapping subproblems
 * - Define state and transition function
 * - Use bottom-up or top-down approach
 * - Optimize space complexity if possible
 * - Handle base cases and edge conditions
 *
 * TIME COMPLEXITY: Varies based on problem - typically O(n) to O(n²)
 * SPACE COMPLEXITY: Varies based on problem - typically O(n) to O(n²)
 *
 * ALTERNATIVE APPROACHES:
 * 1. Recursive: O(2^n) or higher - Without memoization
 * 2. Greedy: O(n) - If greedy choice property holds
 * 3. Divide and Conquer: O(n log n) - For certain problems
 *
 * KEY INSIGHTS:
 * - Look for patterns that suggest DP (optimal substructure)
 * - Consider space optimization (rolling arrays)
 * - Memoization can convert exponential to polynomial time
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
} 