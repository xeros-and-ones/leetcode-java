package merge_two_sorted_lists;

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

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode merged = new ListNode();
    ListNode pointer = merged;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        pointer.next = list1;
        list1 = list1.next;
      } else {
        pointer.next = list2;
        list2 = list2.next;
      }
      pointer = pointer.next;
    }
    if (list1 != null) {
      pointer.next = list1;
    } else {
      pointer.next = list2;
    }

    return merged.next;
  }

  public ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    if (list1.val <= list2.val) {
      list1.next = mergeTwoListsRec(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoListsRec(list1, list2.next);
      return list2;
    }
  }
}
