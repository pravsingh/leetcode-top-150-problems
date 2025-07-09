
import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 *
 * A linked list of length n is given such that each node contains an additional random pointer.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]

 *
 * SOLUTION APPROACH:
 * - Use pointer manipulation techniques
 * - Consider fast/slow pointers, dummy nodes, or reversal
 * - Handle edge cases like empty lists or single nodes
 * - Be careful with pointer assignments to avoid cycles
 *
 * TIME COMPLEXITY: Varies based on approach - typically O(n)
 * SPACE COMPLEXITY: Varies based on approach - typically O(1) to O(n)
 *
 * ALTERNATIVE APPROACHES:
 * 1. Convert to array: O(n) time, O(n) space - Convert to array, process, convert back
 * 2. Recursive: O(n) time, O(n) space - Use recursion
 * 3. Stack/Queue: O(n) time, O(n) space - Use auxiliary data structures
 *
 * KEY INSIGHTS:
 * - Dummy nodes can simplify edge case handling
 * - Fast/slow pointers are useful for cycle detection
 * - Be careful with pointer manipulation to avoid losing nodes
 */
public class CopyListWithRandomPointer {
    public class Node {
        int val;
        Node next;
        Node random;
        
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    private Map<Node, Node> visited = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        if (visited.containsKey(head)) {
            return visited.get(head);
        }
        
        Node newNode = new Node(head.val);
        visited.put(head, newNode);
        
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        
        return newNode;
    }
} 