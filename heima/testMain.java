package heima;

public class testMain {
    
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        arrayQueue.offer(4);
        arrayQueue.offer(5);
        System.out.println(arrayQueue.peek());
        arrayQueue.poll();
        arrayQueue.loop();
}
}