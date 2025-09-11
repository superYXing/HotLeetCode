package heima;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class BlockingQueue {
    String[] array;
    int tail;
    int size;
    int head; // 添加head指针，用于出队操作
    ReentrantLock lock = new ReentrantLock();
    Condition tailWaits = lock.newCondition();
    Condition headWaits = lock.newCondition();
    public BlockingQueue(int capacity){
        array = new String[capacity];
        head=0;
        tail=0;
        size=0;
    }
    public boolean offer(String s) throws InterruptedException{
        //上锁
        lock.lockInterruptibly();
        try{
            while(isFull()){
                tailWaits.await();
            //等待，直到非满
        }
        array[tail] = s;
        size++;
        if(++tail == array.length){
            tail = 0;
        }
        headWaits.signal();
        }finally{
            lock.unlock();
        }
        return true;
        
    }
    public boolean offer(String s,long time) throws InterruptedException{
        //上锁
        lock.lockInterruptibly();
        long t = TimeUnit.MILLISECONDS.toNanos(time);
        try{
            while(isFull()){
                if(t<=0) return false;
                //等待，直到非满
                t = tailWaits.awaitNanos(t);
            
        }
        array[tail] = s;
        size++;
        if(++tail == array.length){
            tail = 0;
        }
        headWaits.signal();
        }finally{
            lock.unlock();
        }
        return true;
        
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size == array.length;
    }
    public void loop(){
        for(int i =head;i<size;i++){
            System.out.println(array[i]);
        }
    }
    public String poll() throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while(isEmpty()) {
             headWaits.await();   
            }
            
            String result = array[head];
            
            array[head] = null; // help gc
            head = (head + 1) % array.length; // 环形缓冲区
            size--;
            
            // 通知等待中的生产者线程
            tailWaits.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }
    
}

