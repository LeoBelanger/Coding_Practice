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



// Question #200: Number of Islands
class Solution {
    private int n, m;

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        n = grid.length;
        if(n == 0) {
            return 0;
        }
        m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    DFS(grid, i, j);
                    ++numIslands;
                }
            }
        }
        return numIslands;
    }

    private void DFS(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }

        //Turn the current node into 0 and recursively change remaining island to 0 as well
        grid[i][j] = '0';
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }
}
/* The main thing with this question is to recursively change all 1's of an island to 0's using DFS(). Once you find the
 * first 1, you increase count once and then change all linked land to 0's before finally returning and looking for the next
 * new island. 
 */