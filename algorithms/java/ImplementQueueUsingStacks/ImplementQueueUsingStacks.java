// Source : https://leetcode.com/problems/implement-queue-using-stacks/
// Author : cornprincess
// Date   : 2020-04-27

/***************************************************************************************************** 
 *
 * Implement the following operations of a queue using stacks.
 * 
 * 	push(x) -- Push element x to the back of queue.
 * 	pop() -- Removes the element from in front of queue.
 * 	peek() -- Get the front element.
 * 	empty() -- Return whether the queue is empty.
 * 
 * Example:
 * 
 * ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
 * 
 * queue.push(1);
 * queue.push(2);  
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * 
 * Notes:
 * 
 * 	You must use only standard operations of a stack -- which means only push to top, peek/pop 
 * from top, size, and is empty operations are valid.
 * 	Depending on your language, stack may not be supported natively. You may simulate a stack 
 * by using a list or deque (double-ended queue), as long as you use only standard operations of a 
 * stack.
 * 	You may assume that all operations are valid (for example, no pop or peek operations will 
 * be called on an empty queue).
 * 
 ******************************************************************************************************/

package ImplementQueueUsingStacks;

import java.util.Stack;

// approach1 Two Stack Push-O(n) per operation; Pop-O(1) per operation
class MyQueue {
    private int front;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    // Time complexity : O(n)
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    //Time complexity : O(1).
    //Space complexity : O(1).
    public int pop() {
        int pop = s1.pop();
        if (!s1.isEmpty()) {
            front = s1.peek();
        }
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }

    @Override
    public String toString() {
        return s1.toString();
    }
}

// approach1 Two Stack Push-O(1) per operation; Pop-Amortized O(1) per operation
class  MyQueue2 {
    private int front;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue2() {

    }

    /** Push element x to the back of queue. */
    // Time complexity : O(1)
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    //Time complexity : O(1). O(n)
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
