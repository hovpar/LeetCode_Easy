package p225_implement_stack_using_queues;

import java.util.ArrayDeque;
import java.util.Queue;

class OneQueueStack implements MyStack {
    private Queue<Integer> queue;

    OneQueueStack() {
        queue = new ArrayDeque<>();
    }

    @Override
    public void push(int x) {
        queue.add(x);
        if (queue.size() >= 1) {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.poll());
            }
        }
    }

    @Override
    public int pop() {
        return queue.poll();
    }

    @Override
    public int top() {
        return queue.peek();
    }

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }
}
