package uvg.edu;

public interface Ipila<T> {
    public void push(T item);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public int size();
}
