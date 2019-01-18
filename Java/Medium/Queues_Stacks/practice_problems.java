Question #622: Design Circular Queue
class MyCircularQueue {
    int q[];
    int head, tail = -1, len = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        q = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()) {
            tail = (tail + 1) % q.length;
            q[tail] = value;
            len++;
            return true;
        } else {
            return false;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()) {
            head = (head + 1) % q.length;
            len--;
            return true;
        } else {
            return false;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) {
            return -1;
        } else {
            return q[head];
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) {
            return -1;
        } else {
            return q[tail];
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(len == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(len == q.length) {
            return true;
        } else {
            return false;
        }
    }
}
