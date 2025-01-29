package uvg.edu;

/**
 * The Ipila interface defines the basic operations for a stack data structure.
 * Authors:
 *  Javier Alvarado 24546
 *  Juan Montenegro 24750
 *  Jonathan Tubac 24484
 *
 * @param <T> the type of elements in this stack
 */
public interface IStack<T> {
    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed onto this stack
     */
    public void push(T item);

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return the object at the top of this stack
     * @throws IllegalArgumentException if this stack is empty
     */
    public T pop();

    public T peek();

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if this stack contains no elements
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int size();
}