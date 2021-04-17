package queue;

import java.util.Random;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/17 8:34
 */
public class Test {
    public static void main(String[] args) {
        IQueue<Integer> arrayQueue=new ArrayQueue<>();
        IQueue<Integer> loopQueue=new LoopQueue<>();
        int count=100000;
        getTime(arrayQueue,count);
        getTime(loopQueue,count);
    }
    public static void getTime(IQueue queue,int count){
        long startTime=System.nanoTime();
        for (int i=0;i<count;i++)
            queue.enQueue(new Random().nextInt(Integer.MAX_VALUE));
        for (int i=0;i<count;i++)
            queue.deQueue();
        long endTime=System.nanoTime();
        System.out.println(queue+":"+(endTime-startTime)/1000000000.0+"s");
    }
}
