package heima;

public interface Dqueue<E> {
    boolean OfferFirst(E value);
    boolean OfferLast(E value);

    E peekFirst();

    E peekLast();

    E pollFirst();

    E pollLast();

    boolean isEmpty();

    boolean isFull();

}
