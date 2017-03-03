package datastructure;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by wyy on 3/4/17.
 * Using stack to implement a queue, here the java.util.Stack
 * the only permitted operations of stack are: pop() peek() push() isEmpty() size()
 * using two stack front and end. front.pop == queue.pop  end.push == queue.push
 */
public class MyQueue {

    //variables
    private Stack<Integer> front;
    private  Stack<Integer> end;
    //

    public MyQueue(){
        front = new Stack<Integer>();
        end = new Stack<Integer>();
    }

    public void push(int x){
       while(!front.isEmpty())
           end.push(front.pop());
        end.push(x);
    }
    public int pop(){
        while(!end.isEmpty())
            front.push(end.pop());
        return front.pop();
    }
    public int peek(){
       while(!end.isEmpty())
           front.push(end.pop());
        return front.peek();
    }
    public boolean empty(){
        return (front.isEmpty())&&(end.isEmpty());
    }


}
