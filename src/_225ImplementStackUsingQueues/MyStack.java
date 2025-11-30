package _225ImplementStackUsingQueues;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    // Two queue approach
//    private Queue<Integer> q1;
//    private Queue<Integer> q2;
//
//    MyStack() {
//        q1 = new ArrayDeque<>();
//        q2 = new ArrayDeque<>();
//    }
//
//    void push(int x) {
//        q1.add(x);
//
//    }
//
//    int pop() {
//        while (q1.size() > 1) {
//            q2.add(q1.poll());
//        }
//        var value = q1.poll();
//        swap();
//        return value;
//
//    }
//
//    int top() {
//        while (q1.size() > 1) {
//            q2.add(q1.poll());
//        }
//        var value = q1.poll();
//        q2.add(value); // put it back! (unlike pop)
//        swap();
//
//        return value;
//
//    }
//
//    boolean empty() {
//        return q1.isEmpty() && q2.isEmpty();
//
//    }
//
//    private void swap() {
//        Queue<Integer> temp = q1;
//        q1 = q2;
//        q2 = temp;
//    }
    // One queue approach
    private Queue<Integer> queue;

    MyStack() {
        queue = new ArrayDeque<>();
    }

    void push(int x) {
        queue.add(x);
        if (queue.size() >= 1) {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.poll());
            }
        }
    }

    int pop() {
        return queue.poll();
    }

    int top() {
        return queue.peek();
    }

    boolean empty() {
        return queue.isEmpty();
    }

}
/*
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
