/**
 * An extremely simple implementation of a stack as a linked list.
 */
public class IntStack {

    /**
     * A simple node class.
     */
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /** The top node in the stack. For an empty stack this is null. */
    private Node topNode;

    /**
     * Add a new value to the top of the stack.
     * @param value A new int to add on the top of the stack.
     */
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = topNode;
        topNode = newNode;
    }

    /**
     * Pop the top element off the top of the stack.
     * @return The popped value.
     * @throws IllegalStateException
     */
    public int pop() throws IllegalStateException {
        if (topNode==null) {
            throw new IllegalStateException("The stack is empty.");
        } else {
            int returnValue = topNode.value;
            topNode = topNode.next;
            return returnValue;
        }
    }
}
