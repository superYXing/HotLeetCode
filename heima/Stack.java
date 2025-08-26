package heima;

public interface Stack<E> {
    boolean offer(E value);
    boolean isEmpty();
    boolean isFull();

    E peek();

    E poll();
}
