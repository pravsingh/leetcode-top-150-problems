
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * SOLUTION APPROACH:
 * - Use iterative approach with stack to simulate recursion
 * - Keep track of current node and stack of nodes to process
 * - Go as far left as possible, pushing nodes onto stack
 * - When can't go left, pop from stack, add to result, go right
 * - Continue until stack is empty and current is null
 * - This simulates the recursive inorder traversal
 *
 * TIME COMPLEXITY: O(n) - Visit each node exactly once
 * SPACE COMPLEXITY: O(h) - Stack space proportional to tree height
 *
 * ALTERNATIVE APPROACHES:
 * 1. Recursive: O(n) time, O(h) space - Simple recursive implementation
 * 2. Morris Traversal: O(n) time, O(1) space - Threaded binary tree approach
 * 3. Threaded Tree: O(n) time, O(1) space - Modify tree structure temporarily
 *
 * KEY INSIGHTS:
 * - Stack simulates the call stack of recursive approach
 * - Always go left first, then process current, then go right
 * - Morris traversal is space-optimal but modifies tree structure
 * - Iterative approach is more memory-efficient than recursive for deep trees
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // Go as far left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // Process current node and go right
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        
        return result;
    }
} 