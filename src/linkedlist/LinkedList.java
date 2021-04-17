package linkedlist;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/17 9:46
 */
public class LinkedList<E> {
    private class Node<E> {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node<E> dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node<>(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("插入位置非法！");

        Node<E> preNode = dummyHead;

        for (int i = 0; i < index; i++)
            preNode = preNode.next;

        preNode.next = new Node(e, preNode.next);
        size++;
    }

}
