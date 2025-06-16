package merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
public class Solution {

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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode();
        ListNode pointer = merged;
        List<Integer> tmp = new ArrayList<>();

        if (lists.length == 1) {
            return lists[0];
        }

        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                if (lists[i] != null) {
                    tmp.add(lists[i].val);
                    lists[i] = lists[i].next;
                }
            }
        }
        tmp.sort(null);
        for (int i : tmp) {
            ListNode t = new ListNode(i);
            pointer.next = t;
            pointer = pointer.next;
        }

        return merged.next;
    }

    public ListNode mergeKListsOptimized(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeKlistsHelper(lists, 0, lists.length - 1);
    }

    public ListNode mergeKlistsHelper(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start + 1 == end) return mergeTwoLists(lists[start], lists[end]);

        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode();
        ListNode curr = merged;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return merged.next;
    }
}
