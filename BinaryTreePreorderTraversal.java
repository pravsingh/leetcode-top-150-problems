
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 *
 * Example 2:
 * Input: root = []
 * Output: []

 *
 * SOLUTION APPROACH:
 * - Use tree traversal techniques (DFS/BFS)
 * - Consider recursive or iterative approaches
 * - Handle edge cases like null nodes or single nodes
 * - Use appropriate data structures for level-order traversal
 *
 * TIME COMPLEXITY: Varies based on approach - typically O(n) where n is number of nodes
 * SPACE COMPLEXITY: Varies based on approach - typically O(h) to O(n) where h is height
 *
 * ALTERNATIVE APPROACHES:
 * 1. Recursive DFS: O(n) time, O(h) space - Use recursion
 * 2. Iterative DFS: O(n) time, O(h) space - Use stack
 * 3. BFS: O(n) time, O(w) space - Use queue for level-order
 *
 * KEY INSIGHTS:
 * - Choose traversal order based on problem requirements
 * - Consider space complexity of recursion vs iteration
 * - Handle null nodes and edge cases carefully
 */
public class BinaryTreePreorderTraversal {
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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root != null) stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);
            
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        
        return result;
    }
} 