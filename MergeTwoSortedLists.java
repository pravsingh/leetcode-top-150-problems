
/**
 * 21. Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2. Merge the two lists into one sorted list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * SOLUTION APPROACH:
 * - Use dummy head to simplify the merging process
 * - Compare nodes from both lists and link the smaller one
 * - Move the pointer of the list from which we took the node
 * - Continue until one list is exhausted
 * - Link the remaining nodes from the non-empty list
 * - Return the merged list (skip dummy head)
 *
 * TIME COMPLEXITY: O(m + n) where m and n are the lengths of the input lists
 * SPACE COMPLEXITY: O(1) - Only use a few pointers, no extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. Recursive: O(m + n) time, O(m + n) space - Recursive merging
 * 2. In-place: O(m + n) time, O(1) space - Modify one list in-place
 * 3. Convert to array: O(m + n) time, O(m + n) space - Convert, merge, convert back
 *
 * KEY INSIGHTS:
 * - Dummy head eliminates special case for the first node
 * - Always link the smaller node to avoid losing track
 * - Handle remaining nodes from the longer list
 * - Be careful with pointer assignments to avoid cycles
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // Link remaining nodes
        current.next = (list1 != null) ? list1 : list2;
        
        return dummy.next;
    }
} 