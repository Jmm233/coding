package stackqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
    队列最大值
    https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 */
public class MaxQueue03 {
    Queue<Integer> queue;
    Deque<Integer> maxQueue;
    public MaxQueue03() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int temp = queue.poll();
        if (temp == maxQueue.peekFirst()) {
            maxQueue.pollFirst();
        }
        return temp;
    }
}
