package heima;

public class testMain {
    
    public static void main(String[] args) {
        // ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        // arrayQueue.offer(1);
        // arrayQueue.offer(2);
        // arrayQueue.offer(3);
        // arrayQueue.offer(4);
        // arrayQueue.offer(5);
        // System.out.println(arrayQueue.peek());
        // arrayQueue.poll();
        // arrayQueue.loop();

        // LinkedListStack<String> stack = new LinkedListStack<>(5);
        // stack.offer("1");
        // stack.offer("2");
        // stack.loop();
        // String str = stack.poll();
        // System.out.println(str);

        // ArrayStack<Integer> arrStack = new ArrayStack<>(5);
        // if(arrStack.isEmpty()) System.out.println("Empty Stack");
        // for(int i =0;i<5;i++) arrStack.offer(i);
        // arrStack.loop();
        // System.out.println(arrStack.poll());
        // System.out.println(arrStack.peek());
        // arrStack.offer(4);
        // arrStack.offer(5);
        // if(!arrStack.offer(6)) System.out.println("index out of bound");
        // arrStack.loop();


        DqueueLinkedList<Integer> dqueue = new DqueueLinkedList<>(5);
        dqueue.OfferFirst(1);
        dqueue.OfferFirst(2);
        dqueue.OfferFirst(3);
        // dqueue.loop();
         dqueue.OfferLast(4);
         dqueue.OfferLast(5);
        //  dqueue.OfferLast(6);
        dqueue.loop();

        System.out.println("--------------"+dqueue.pollFirst());
        System.out.println(dqueue.pollLast());
        System.out.println(dqueue.peekFirst());
        System.out.println(dqueue.peekLast());

}
}