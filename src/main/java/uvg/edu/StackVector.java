package uvg.edu;
import java.util.Vector;

/**
 * The StackVector class implements a stack using a Vector.
 * Authors:
 *  Javier Alvarado 24546
 *  Juan Montenegro 24750
 *  Jonathan Tubac 24484
 *
 * @param <T> the type of elements in this stack
 */
public class StackVector<T> implements IStack<T> {
    private Vector<T> vector;

    /**
     * Constructs an empty stack.
     */
    public StackVector() {
        vector = new Vector<>();
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed onto this stack
     */
    @Override
    public void push(T item) {
        vector.add(item);
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if this stack contains no elements
     */
    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return the object at the top of this stack
     * @throws IllegalArgumentException if this stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Pila vacía");
        } else {
            return vector.remove(vector.size() - 1);
        }
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    @Override
    public int size() {
        return vector.size();
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return the object at the top of this stack
     * @throws IllegalArgumentException if this stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Pila vacía");
        } else {
            return vector.get(vector.size() - 1);
        }
    }
}