public interface Stack<E> {
    
    // Returns the number of elements in the stack
    int size();

    // Checks whether the stack is empty
    boolean isEmpty();

    // Adds an element at the top of the stack
    void push(E e);

    // Returns the element at the top of the stack
    E top();

    // Removes and returns the element at the top of the stack
    E pop();
}
