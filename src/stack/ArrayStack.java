package stack;

import array.Array;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/06 20:49
 */
public class ArrayStack<E> implements IStack<E>{
    private Array<E> array;
    public ArrayStack(int capacity){
        array=new Array<>(capacity);
    }
    public ArrayStack(){
        array=new Array<>();
    }
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Stack:");
        res.append("[");
        //错误，当栈为空时size=0
//        for (int i=0;i<array.getSize()-1;i++){
//            res.append(array.get(i)+",");
//        }
//        res.append(array.getLast()+"] top");
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize()-1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack=new ArrayStack<>();
        for (int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
//            stack.pop();
        }
//        stack.pop();
        System.out.println(stack);

    }
}
