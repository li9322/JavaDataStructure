package stack;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/06 20:46
 */
interface IStack<E> {
    void push(E e);
    E pop();
    E peek();
    int getSize();
    boolean isEmpty();
}
