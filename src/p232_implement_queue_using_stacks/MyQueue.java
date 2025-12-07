package p232_implement_queue_using_stacks;

import java.util.Stack;

class MyQueue {

    private final Stack<Integer> input;
    private final Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek(); // instead to call peek() you can extract the transfer logic to extra function
                // and call it in both methods
        return output.pop();

    }

    public int peek() {
        if (output.empty()) {
            // move all elements from input to output
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();

    }

    public boolean empty() {
        return (input.empty() & output.empty());

    }
}

// Your MyQueue object will be instantiated and called as such:
// MyQueue obj = new MyQueue();
// obj.push(x);
// int param_2 = obj.pop();
// int param_3 = obj.peek();
// boolean param_4 = obj.empty();
