package linkedlist;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/17 9:46
 */
public class LinkedList_not_DummyHead<E> {
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
            return e.toString()  ;
        }
    }

    /** 错误：
     *     private Node<E> node;
     *     private Node<E> head;
     *     private int size;
     *
     *     public LinkedList() {
     *         this.node = new Node<>();
     *         this.head = node;
     *         this.size = 0;
     *     }
     */
   private Node<E> head;
   private int size;
   public LinkedList_not_DummyHead(){
       head=null;
       size=0;
   }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 错误：
     *  在头部添加节点后，该节点即为头节点
     *    Node<E> node = new Node<>(e);
     *    node.next = head.next;
     *    head.next = node;
     *    实为在链表中间插入元素
     *
     * @param e
     */
    public void addFirst(E e) {
      /*  Node<E> node = new Node<>(e);
        node.next = head;
        head = node;*/
      /*  错误，传入的next本身即为下一个元素，传入的元素本身即为next
        head=new Node<>(e,head.next);*/
        head=new Node<>(e,head);
        size++;
    }

    public void addLast(E e){
       add(size,e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("插入位置非法！");
        if (index == 0)
            addFirst(e);
        else {
            Node<E> preNode= head;;
            for (int i = 0; i < index-1; i++) {
                preNode=preNode.next;
            }
//        Node<E> node= new Node<>(e);;
//        node.next=preNode.next;
//        preNode.next=node;
            preNode.next=new Node(e,preNode.next);
            size++;
        }
    }
}
