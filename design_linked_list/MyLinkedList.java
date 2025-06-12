package src.design_linked_list;

public class MyLinkedList {
  private int length = 0;
  private Node head;
  private Node tail;

  class Node {
    int value;
    Node next;

    Node() {}

    Node(int val) {
      this.value = val;
    }

    Node(int val, Node next) {
      this.value = val;
      this.next = next;
    }
  }

  public MyLinkedList() {
    Node node = new Node();
    head = node;
    tail = node;
  }

  public Node find(int index) {

    if (index < 0 || index >= length) return null;

    Node temp = head.next;
    int idx = 0;
    while (idx <= index) {
      temp = temp.next;
      idx++;
    }
    return temp;
  }

  public int get(int index) {
    if (index < 0 || index >= length || length == 0) return -1;

    return find(index).value;
  }

  public void addAtHead(int val) {
    Node temp = new Node(val);
    temp.next = head.next;
    head.next = null;
    head = temp;
    length++;

    if (length == 1 || length == 0) {
      tail = temp;
    }
  }

  public void addAtTail(int val) {
    Node temp = new Node(val);
    tail.next = temp;
    tail = temp;
    length++;
  }

  public void addAtIndex(int index, int val) {
    if (index == length) addAtTail(val);
    if (index >= length) return;

    if (index < length) {
      Node prev = find(index - 1);
      Node temp = new Node(val);

      temp.next = prev.next;
      prev.next = temp;
      length++;
    } else return;
  }

  public void deleteAtIndex(int index) {
    Node prev = find(index - 1);
    Node temp = prev.next;

    prev.next = temp.next;
    temp.next = null;
    length--;
  }
}
