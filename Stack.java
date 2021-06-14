//Aufgabe 1
public interface Stack<T>
{
    abstract public void push( T element);
    abstract T pop();
    abstract boolean isEmpty();
    abstract T peek();
    abstract int getSize();
}
