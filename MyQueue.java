public class MyQueue {
    private java.util.Deque<Integer> stack1;
    private java.util.Deque<Integer> stack2;
    public MyQueue() {
        this.stack1 = new java.util.ArrayDeque<Integer>();
        this.stack2 = new java.util.ArrayDeque<Integer>();
    }
    public void push(int x) {
        this.stack1.push(x);
    }
    public void pop() {
        this.peek();
        this.stack2.pop();
    }
    public int peek() {
        if (this.stack2.isEmpty()) {
            while (!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2.peek();
    }
    public boolean empty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }
}