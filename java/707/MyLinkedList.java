public class MyLinkedList {

    private int size = 0;

    private MyNode first;

    private MyNode last;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        MyNode x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the
     * new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyNode node = new MyNode(val, null);
        if (size == 0) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyNode node = new MyNode(val, null);
        if (size == 0) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the
     * length of linked list, the node will be appended to the end of linked list. If index is
     * greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } else if (index == size) {
            addAtTail(val);
        } else {
            MyNode x = first;
            for (int i = 0; i < index - 1; i++) {
                x = x.next;
            }
            MyNode node = new MyNode(val, x.next);
            x.next = node;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        MyNode x = first;
        if (index == 0) {
            first = x.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                x = x.next;
            }
            x.next = x.next.next;
            if (index == size - 1) {
                last = x;
            }
        }
        size--;
    }

    private static class MyNode {
        Integer val;
        MyLinkedList.MyNode next;

        MyNode(Integer val, MyLinkedList.MyNode next) {
            this.val = val;
            this.next = next;
        }
    }

}