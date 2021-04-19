package stack;

import linkedlist.LinkedList;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/19 20:51
 */
public class LinkedListStack<E> implements IStack<E>{
    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList=new LinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
