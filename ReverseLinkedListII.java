
/**
 * 92. Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes from position left to position right, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]

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
public class ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        ListNode current = prev.next;
        ListNode next = current.next;
        
        for (int i = 0; i < right - left; i++) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = current.next;
        }
        
        return dummy.next;
    }
} 