package collectionframework;

import java.util.ArrayList;

public class CustomStack<E> {
    private ArrayList<E> stack;

    public CustomStack() {
        stack = new ArrayList<>();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public E push(E item) {
        stack.add(item);
        return item;
    }

    public E pop() {
        if (empty())
            throw new RuntimeException("Stack is empty");
        return stack.remove(stack.size() - 1);
    }

    public E peek() {
        if (empty())
            throw new RuntimeException("Stack is empty");
        return stack.get(stack.size() - 1);
    }

    public int search(E item) {
        int index = stack.indexOf(item);
        if (index == -1)
            return -1;
        // Convert from bottom-based index to 1-based position from top
        return stack.size() - index;
    }

    public int size() {
        return stack.size();
    }

    public String toString() {
        return this.stack.toString();
    }
}
