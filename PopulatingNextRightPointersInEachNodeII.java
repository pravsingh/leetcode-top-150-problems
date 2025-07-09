
/**
 * 117. Populating Next Right Pointers in Each Node II
 *
 * Given a binary tree, populate each next pointer to point to its next right node.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
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
public class PopulatingNextRightPointersInEachNodeII {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
        
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node head = root;
        Node dummy = new Node(0);
        
        while (head != null) {
            Node current = dummy;
            
            while (head != null) {
                if (head.left != null) {
                    current.next = head.left;
                    current = current.next;
                }
                if (head.right != null) {
                    current.next = head.right;
                    current = current.next;
                }
                head = head.next;
            }
            
            head = dummy.next;
            dummy.next = null;
        }
        
        return root;
    }
} 