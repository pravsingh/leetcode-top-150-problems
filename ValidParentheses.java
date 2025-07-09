
import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * SOLUTION APPROACH:
 * - Use stack to keep track of opening brackets
 * - For each opening bracket, push corresponding closing bracket
 * - For each closing bracket, check if it matches the top of stack
 * - Return false if stack is empty or brackets don't match
 * - Return true only if stack is empty at the end
 *
 * TIME COMPLEXITY: O(n) - Single pass through the string
 * SPACE COMPLEXITY: O(n) - Stack to store opening brackets
 *
 * ALTERNATIVE APPROACHES:
 * 1. HashMap: O(n) - Use HashMap to store bracket pairs
 * 2. Array: O(n) - Use fixed-size array for bracket tracking
 * 3. Recursive: O(n) - Recursive approach with stack simulation
 *
 * KEY INSIGHTS:
 * - Stack is perfect for matching pairs in LIFO order
 * - Push closing brackets instead of opening ones for easier matching
 * - Check for empty stack before popping to handle invalid cases
 * - Final check ensures all brackets are properly closed
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
} 