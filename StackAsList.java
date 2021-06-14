//Aufgabe 2
import java.util.EmptyStackException;

public class StackAsList implements Stack {

    Node topNode;
    int size;
    String showContents="";

    //Constructor
    public StackAsList()
    {
        size=0;
        topNode=null;
    }


    @Override
    public int getSize()
    {
        return size;
    }


    @Override
    public void push(Object element)
    {
        topNode = new Node(element,topNode);
        size++;
        showContents += element; //123
    }

    @Override
    public Object pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        Node oldTop = topNode;
        topNode = topNode.getNext();
        size--;
        return oldTop.getData();

    }

    @Override
    public boolean isEmpty()
    {
        if(size != 0) {return false;} else {return true;}
    }

    @Override
    public Object peek() {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData() ;
    }


    @Override
    public String toString()
    {
        String reverse ="";
        for (int i =size; i>0 ;i--)
        {
            reverse += "["+showContents.charAt(i-1)+"]"+"\n";
        }
        return reverse;
    }



    //inner class to manege the stack values
    private class Node<T>
    {
        T data; //the actual value storage
        Node next; // the reference storage

        //Constructor
        public Node(T data, Node<T> next)
        {
            this.data= data;
            this.next=next;
        }


        public Node getNext()
        {
            return next;
        }
        public T getData()
        {
            return data;
        }
    }
}