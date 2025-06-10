package merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.List;

/** Definition for singly-linked list. */
public class Solution {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

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
}
