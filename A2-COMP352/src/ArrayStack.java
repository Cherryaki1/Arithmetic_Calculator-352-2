import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    public static int CAPACITY = 10;
    private E[] S;
    private int top = -1;

    public ArrayStack() {
        this(CAPACITY);
    }
    
    public ArrayStack(int capacity) {
        S = (E[]) new Object[capacity];
    }

    // Returns the number of elements in the stack
    @Override
    public int size() {
        return this.top + 1;
    }

    // Checks whether the stack is empty
    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    // Adds an element at the top of the stack
    @Override
    public void push(E e) {
        if (size() == S.length) {
            doubleSize();
        }
        S[++this.top] = e;
    }

    // Returns the element at the top of the stack
    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        } else return S[this.top];
    }

    // Removes and returns the element at the top of the stack
    @Override
    public E pop() throws EmptyStackException {
        if (S.length == 0) {
            throw new EmptyStackException();
        }
        E tmp = S[this.top];
        S[this.top] = null;
        this.top--;
        return tmp;
    }

    // Doubles the size of the stack
    public void doubleSize() {
        E[] tmp = (E[]) new Object[S.length * 2];
        for (int i = 0; i < S.length; i++) {
            tmp[i] = S[i];
        }
        S = tmp;
    }
    
}
