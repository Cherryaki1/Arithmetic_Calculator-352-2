public class ArrayStack<E> implements Stack<E> {
    private E[] S;
    private int top = -1;
    
    public ArrayStack(int size) {
        S = (E[]) new Object[size];
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
        //exception if stack is full
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
        E tmp = S[this.top];
        S[this.top] = null;
        this.top--;
        return tmp;
    }
    
}
