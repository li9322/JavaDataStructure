package queue;


import linkedlist.LinkedList;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/19 22:44
 */
public class LinkedListQueue<E> implements IQueue<E> {

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

    private Node<E> head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enQueue(E e) {
        if (tail == null) {
            tail = new Node<>(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {
//        if (head==null)
        if (isEmpty())
            throw new IllegalArgumentException("队列为空，不能出队");

        Node<E>  retNode = head;
        head = head.next;
        retNode.next=null;
        if (head==null)
            tail=null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空，不能出队");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Queue: front ");
        Node cur =head;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("null tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
//                System.out.println("i:"+i+"--"+i%3);
                queue.deQueue();
                System.out.println(queue);
            }

        }
    }
}
