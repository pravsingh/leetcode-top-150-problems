
import java.util.Stack;

/**
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Example:
 * Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * Output: [null,null,null,null,-3,null,0,-2]
 *
 * SOLUTION APPROACH:
 * - Use two stacks: one for all elements, one for minimum elements
 * - Main stack stores all pushed values
 * - Min stack stores minimum values seen so far
 * - For push: always push to main stack, push to min stack only if <= current min
 * - For pop: pop from main stack, pop from min stack if values match
 * - For top: return top of main stack
 * - For getMin: return top of min stack
 *
 * TIME COMPLEXITY: O(1) - All operations are constant time
 * SPACE COMPLEXITY: O(n) - Two stacks to store elements
 *
 * ALTERNATIVE APPROACHES:
 * 1. Single stack with pairs: O(1) time, O(n) space - Store (value, min) pairs
 * 2. Node-based: O(1) time, O(n) space - Each node stores its minimum
 * 3. Math trick: O(1) time, O(1) space - Use mathematical encoding (limited range)
 *
 * KEY INSIGHTS:
 * - Two-stack approach is most intuitive
 * - Min stack only stores values that could be minimum
 * - Duplicate minimums are stored to handle multiple pops
 * - Can optimize by storing count of minimums instead of duplicates
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
} 