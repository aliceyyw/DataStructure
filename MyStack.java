package datastructure;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by wyy on 3/8/17.
 */
public class MyStack {
    //vatiables

    private java.util.LinkedList<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addFirst(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        int temp = queue.remove();
        queue.addFirst(temp);
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
