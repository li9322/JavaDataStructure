/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/13 19:07
 */
public interface IQueue<E> {
     void enQueue(E e);
     E deQueue();
     E getFront();
     int getSize();
     boolean isEmpty();

}
