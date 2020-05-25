package programming.classimplementation;

public class MinStack<T extends Comparable<T>> implements Stack<T> {

    private Node<T> head;
    private int size;

    @Override
    public void push(T value) {
        if (head == null) {
            head = new Node<>(value, value);
        } else {
            Node<T> temp = head;
            head = new Node<>(value, head.min.compareTo(value) > 0 ? value : head.min);
            head.next = temp;
        }
        ++size;
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        Node<T> temp = head;
        head = head.next;
        --size;
        return temp.value;
    }

    @Override
    public T peek() {
        return head.value;
    }

    @Override
    public T min() {
        return head.min;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T value;
        T min;
        Node<T> next;

        public Node(T value, T min) {
            this.value = value;
            this.min = min;
        }
    }
}


interface Stack<T> {

    void push(T value);

    T pop();

    T peek();

    T min();

    int size();
}