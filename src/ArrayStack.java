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
        return array.get(0);
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
}
