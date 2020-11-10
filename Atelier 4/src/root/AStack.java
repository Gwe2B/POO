package root;

public interface AStack {
    /**
     * Test if the stack is empty
     * @return true if the stack is empty, else false
     */
    public boolean isEmpty();

    /**
     * Add an object to the stack
     * @param obj Object to add
     */
    public void push(Object obj);

    /**
     * Get the element on top of the stack
     * @return The element on the top of the stack
     */
    public Object peek();

    /**
     * Get and delete the element on top of the stack
     * @return The element on top of the stack
     */
    public Object pop();
}
