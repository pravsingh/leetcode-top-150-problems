
/**
 * 86. Partition List
 *
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]

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
public class PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;
        
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        
        after.next = null;
        before.next = afterHead.next;
        
        return beforeHead.next;
    }
} 