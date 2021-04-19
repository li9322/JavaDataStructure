package linkedlist;

import javax.management.NotificationEmitter;

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

//        Node<E> node= new Node<>(e);;
//        node.next=preNode.next;
//        preNode.next=node;
        preNode.next = new Node(e, preNode.next);
        size++;
    }

    /*public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("插入位置非法！");
        Node<E> preNode=dummyHead;
        for (int i = 0; i<index; i++)
            preNode=preNode.next;
        Node<E> node=preNode.next;
        return node.getE();
    }*/
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("插入位置非法！");
        Node<E> curNode = dummyHead.next;
        for (int i = 0; i < index; i++)
            curNode = curNode.next;
        return curNode.e;
    }

    public E remove(int index){
        if (index<0 || index>=size)
            throw new IllegalArgumentException("删除位置非法");
        Node<E> preNode=dummyHead;
        for (int i=0;i<index;i++)
            preNode=preNode.next;
        Node<E> curNode=preNode.next;
        preNode.next=curNode.next;
        curNode=null;
        size--;
        return curNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

   /* public boolean contains(E e){
        Node<E> preNode=dummyHead;
        for (int i=0;i<size;i++){
            preNode=preNode.next;
            if (e==preNode.e)
                return true;
        }
        return false;
    }*/
   /* public boolean contains(E e){
        if (isEmpty())
            return false;
        Node<E> curNode=dummyHead.next;
        for (int i=0;i<size;i++){
            if (e==curNode.e)
                return true;
            curNode=curNode.next;

        }
        return false;
    }*/

    public boolean contains(E e) {
        Node<E> curNode = dummyHead.next;
        while (curNode != null) {
            if (e.equals(curNode.e))
                return true;
            curNode = curNode.next;
        }
        return false;
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("修改位置非法！");
        Node<E> curNode = dummyHead.next;
        for (int i = 0; i < index; i++)
            curNode = curNode.next;
        curNode.e = e;
    }

 /*   @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("LinkedList:size = %d\n", size));
        res.append("dummyHead ->");
        Node<E> curNode=dummyHead.next;
        for (int i=0;i<size;i++){
            res.append(curNode.e+"->");
            curNode=curNode.next;
        }
        res.append("null");
        return res.toString();
    }*/

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();

//        Node<E> curNode=dummyHead.next;
//        while (curNode!=null){
//            res.append(curNode.e+"->");
//            curNode=curNode.next;
//        }
        for (Node curNode=dummyHead.next;curNode!=null;curNode=curNode.next)
            res.append(curNode.e+"->");
        res.append("null");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int i=0;i<5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
         linkedList.add(2,33);
        System.out.println(linkedList);
    }
}
