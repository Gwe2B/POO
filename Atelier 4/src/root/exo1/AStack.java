package root.exo1;

public interface AStack {
    /**
     * Test if the stack is empty
     * @return true if the stack is empty, else false
     */
    boolean isEmpty();

    /**
     * Add an object to the stack
     * @param obj Object to add
     */
    void push(Object obj);

    /**
     * Get the element on top of the stack
     * @return The element on the top of the stack
     */
    Object peek();

    /**
     * Get and delete the element on top of the stack
     * @return The element on top of the stack
     */
    Object pop();
}
