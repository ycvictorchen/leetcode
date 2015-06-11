public class MyStack {
    private java.util.Queue<Integer> q1;
    private java.util.Queue<Integer> q2;
    public MyStack() {
        this.q1 = new java.util.LinkedList<Integer>();
        this.q2 = new java.util.LinkedList<Integer>();
    }
    public void push(int x) {
        while (!this.q1.isEmpty()) {
            this.q2.offer(this.q1.poll());
        }
        this.q1.offer(x);
    }
    public void pop() {
        while (this.q1.size() > 1) {
            this.q2.offer(this.q1.poll());
        }
        if (this.q1.size() == 1) {
            this.q1.poll();
            return;
        }
        while (this.q2.size() > 1) {
            this.q1.offer(this.q2.poll());
        }
        if (this.q2.size() == 1) {
            this.q2.poll();
            return;
        }
    }
    public int top() {
        while (this.q1.size() > 1) {
            this.q2.offer(this.q1.poll());
        }
        if (this.q1.size() == 1) {
            return this.q1.peek();
        }
        while (this.q2.size() > 1) {
            this.q1.offer(this.q2.poll());
        }
        return this.q2.peek();
    }
    public boolean empty() {
        return this.q1.isEmpty() && this.q2.isEmpty();
    }
}