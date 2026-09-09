package p225_implement_stack_using_queues;

import java.util.ArrayDeque;
import java.util.Queue;

class TwoQueuesStack implements MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    TwoQueuesStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    @Override
    public void push(int x) {
        q1.add(x);

    }

    @Override
    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        var value = q1.poll();
        swap();
        return value;

    }

    @Override
    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        var value = q1.poll();
        q2.add(value); // put it back! (unlike pop)
        swap();

        return value;

    }

    @Override
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();

    }

    private void swap() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}
