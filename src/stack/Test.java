package stack;

import queue.ArrayQueue;
import queue.IQueue;
import queue.LoopQueue;

import java.util.Random;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/17 8:34
 */
public class Test {
    public static void main(String[] args) {
        IStack<Integer> arrayStack=new ArrayStack<>();
        IStack<Integer> linkedListStack=new LinkedListStack<>();
        int count=100000;
        getTime(arrayStack,count);
        getTime(linkedListStack,count);
    }
    public static void getTime(IStack stack,int count){
        long startTime=System.nanoTime();
        for (int i=0;i<count;i++)
            stack.push(new Random().nextInt(Integer.MAX_VALUE));
        for (int i=0;i<count;i++)
            stack.pop();
        long endTime=System.nanoTime();
        System.out.println(stack+":"+(endTime-startTime)/1000000000.0+"s");
    }
}
