package queue;

import java.util.Arrays;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/15 22:59
 */
public class LoopQueue<E> implements IQueue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;

    }

    @Override
    public E deQueue() {
        if (tail == front)
            throw new IllegalArgumentException("队列已空，不能再出队了");
        /**
         * 错误，应该在容量改变前维护front，否则会产生角标越界
         *  E e = data[front];
         *  data[front] = null;
         *  size--;
         *  if (size == data.length - 1 / 4 && data.length / 2 != 0)
         *      resize(data.length / 2);
         *  front = (front + 1) % data.length;
         */
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return e;
    }

    private void resize(int newCapacity) {
        E[] newdata = (E[]) new Object[newCapacity + 1];
        /**
         * 错误，会产生角标越界
         * for (int i = front; i % data.length != tail; i++)
         *             newdata[i] = data[i];
         * 错误，如果是缩容，会产生角标越界
         * for (int i = front; i != tail; i=(i+1)% data.length)
         *              newdata[i] = data[i];
         * data = newdata;
         */
        for (int i = 0; i < size; i++)
            newdata[i] = data[(i + front) % data.length];
        data = newdata;
        front = 0;
        tail = size;

    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("队列已空，无元素");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("queue.LoopQueue:");
        sb.append("front [");
        for (int i = front; i !=tail; i=(i++)%data.length) {
            sb.append(data[i]);
            if (i == (tail- 1))
                sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
