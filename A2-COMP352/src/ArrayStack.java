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

    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public void push(E e) {
        if (size() == S.length) {
            doubleSize();
        }
        S[++this.top] = e;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        } else return S[this.top];
    }

    @Override
    public E pop() {
        //exception if stack is empty
        E tmp = S[this.top];
        S[this.top] = null;
        this.top--;
        return tmp;
    }

    public void doubleSize() {
        E[] tmp = (E[]) new Object[S.length * 2];
        for (int i = 0; i < S.length; i++) {
            tmp[i] = S[i];
        }
        S = tmp;
    }
    
}
