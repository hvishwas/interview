package programming.classimplementation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds
 * some threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks, and should create a new stack once the previous one
 * exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were
 * just a single stack).
 * <p>
 * Input: capacity = 4 , push(1),push(2),push(2),pop,push(3),push(4),push(5)
 * <p>
 * Output: [[1,2,3,4],[5]]
 */
public class StackOfPlates {
    private int capacity;
    private int size;
    private Deque<Deque<Integer>> stacks;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
        stacks = new LinkedList<>();
    }

    public void push(int value) {
        Deque<Integer> lastStack = stacks.peek();
        if (lastStack == null || capacity == lastStack.size()) {
            lastStack = new LinkedList<>();
            stacks.add(lastStack);
        }
        size++;
        lastStack.push(value);
    }

    public int pop() {
        Deque<Integer> lastStack = stacks.peek();
        if (lastStack == null) {
            throw new RuntimeException("Stack is Empty");
        }
        if (lastStack.size() == 1) {
            stacks.pop();
        }
        return lastStack.pop();
    }
}
