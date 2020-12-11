package com;

public interface AStack<T> {
    /**
     * Test if the stack is empty
     * @return true if the stack is empty, else false
     */
    boolean isEmpty();

    /**
     * Add an object to the stack
     * @param obj Object to add
     */
    void push(T obj);

    /**
     * Get the element on top of the stack
     * @return The element on the top of the stack
     */
    T peek();

    /**
     * Get and delete the element on top of the stack
     * @return The element on top of the stack
     */
    T pop();
}
