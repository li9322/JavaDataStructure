

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/03/25 20:20
 */
public class Array<E> {
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
        int a=data.length;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
       this(10);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("插入位置非法");
        if (size == data.length)
            resize(2 * data.length);
        for (int i = size; i > index; i--)
            data[i] = data[i - 1];
        data[index] = e;
        size++;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        if (contains(e))
            remove(find(e));
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("删除位置非法");
        E result = data[index];
        for (int i = index; i < size; i++)
            data[i] = data[i + 1];
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return result;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    public void update(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("更新位置非法！");
        data[index] = e;
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("查找位置非法！");
        return data[index];
    }
    public E getLast(){
        return get(size-1);
    }
    public E getFirst(){
        return get(0);
    }
    // 修改index索引位置的元素为e
    public  void set(int index,E e){
        if (index<0 || index>=size)
            throw new IllegalArgumentException("设置位置非法！");
        data[index]=e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e))
                return true;
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e))
                return i;
        return -1;
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array:size = %d ,capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i] + ", ");
        }
        sb.append(data[size - 1] + "]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        System.out.println(array.toString());
        array.add(1, 5);
        System.out.println(array.toString());
        array.addFirst(8);
        System.out.println(array.toString());
        System.out.println(array.contains(6));
        System.out.println(array.contains(5));
        System.out.println(array.find(5));
        System.out.println(array.find(6));
        array.removeElement(2);
        System.out.println(array);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
            System.out.println(array);
        }
    }
}
