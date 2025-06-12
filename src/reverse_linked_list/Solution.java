package reverse_linked_list;

public class Solution {
    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        ListNode before = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = before;
            before = curr;
            curr = temp;
        }
        return before;
    }
}
