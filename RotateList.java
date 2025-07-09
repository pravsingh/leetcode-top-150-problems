
/**
 * 61. Rotate List
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]

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
public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        k = k % length;
        if (k == 0) return head;
        
        current.next = head;
        for (int i = 0; i < length - k; i++) {
            current = current.next;
        }
        
        ListNode newHead = current.next;
        current.next = null;
        return newHead;
    }
} 