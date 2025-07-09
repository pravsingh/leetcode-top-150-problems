
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
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
public class BinaryTreePostorderTraversal {
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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            TreeNode current = stack.peek();
            
            if (current.right == null || current.right == lastVisited) {
                result.add(current.val);
                stack.pop();
                lastVisited = current;
            } else {
                root = current.right;
            }
        }
        
        return result;
    }
} 