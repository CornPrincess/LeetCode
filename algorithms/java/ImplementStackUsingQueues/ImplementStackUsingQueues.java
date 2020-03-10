// Source : https://leetcode.com/problems/implement-stack-using-queues/
// Author : cornprincess
// Date   : 2020-03-10

/***************************************************************************************************** 
 *
 * Implement the following operations of a stack using queues.
 *
 * 	push(x) -- Push element x onto stack.
 * 	pop() -- Removes the element on top of the stack.
 * 	top() -- Get the top element.
 * 	empty() -- Return whether the stack is empty.
 *
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);  
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 *
 * Notes:
 *
 * 	You must use only standard operations of a queue -- which means only push to back, peek/pop 
 * from front, size, and is empty operations are valid.
 * 	Depending on your language, queue may not be supported natively. You may simulate a queue 
 * by using a list or deque (double-ended queue), as long as you use only standard operations of a 
 * queue.
 * 	You may assume that all operations are valid (for example, no pop or top operations will be 
 * called on an empty stack).
 *
 ******************************************************************************************************/

package ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
