package uvg.edu;
import java.util.Vector;

public class StackVector<T> implements Ipila<T>{
    private Vector<T> vector;

    public StackVector(){
        vector = new Vector<>();
    }

    @Override
    public void push(T item){
        vector.add(item);
    }

    @Override
    public T pop(){
        return vector.remove(vector.size() - 1);
    }

    @Override
    public T peek(){
        return vector.lastElement();
    }

    @Override
    public boolean isEmpty(){
        return vector.isEmpty();
    }

    @Override
    public int size(){
        return vector.size();
    }
}
