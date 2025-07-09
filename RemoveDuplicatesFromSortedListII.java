
/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]

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
public class RemoveDuplicatesFromSortedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
} 