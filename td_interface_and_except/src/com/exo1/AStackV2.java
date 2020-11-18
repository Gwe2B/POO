package com.exo1;

import java.util.EmptyStackException;
import com.exo1.exception.FullStackException;

public interface AStackV2 {
    /**
     * Verify if the stack is empty
     * @return true if the stack is empty
     */
    boolean isEmpty();

    /**
     * Add an element to the stack
     * @param obj The element to add
     * @exception FullStackException if the stack is full
     */
    void push(Object obj) throws FullStackException;

    /**
     * Get the last element of the stack
     * @return The last stack element
     * @exception EmptyStackException if the stack is empty
     */
    Object peek() throws EmptyStackException;

    /**
     * Remove the last element of the stack
     * @return The removed element
     * @exception EmptyStackException if the stack is empty
     */
    Object pop() throws EmptyStackException;
}
