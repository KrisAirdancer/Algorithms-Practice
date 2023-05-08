/**
 * IDEA:
 * - When items are added, cycle the queue such that the most recently added element
 *   is at the front of the queue.
 * - Not sure why the second queue is needed.
 * 
 * PERFORMANCE:
 * - Time Complexity: O(N) - Where N is the number of items in the queue. Pop() and
 *   Peek() will still only take O(1) time, but Push() will take O(N) time b/c we have
 *   to cycle the entire queue of N elements to get the newest element to the front.
 * - Memory Complexity: O(N) - Storing a queue of N element will take O(N) space.
 * 
 */
public class MyStack {
   
    private Queue<int> queue;
    
    public MyStack() {
        
        queue = new Queue<int>();
    }
    
    public void Push(int x) {
        
        queue.Enqueue(x);
        
        for (int i = 0; i < queue.Count - 1; i++) {
            queue.Enqueue(queue.Dequeue()); // Move the front element to the back
        }
    }
    
    public int Pop() {
        return queue.Dequeue();
    }
    
    public int Top() {
        return queue.Peek();
    }
    
    public bool Empty() {
        return queue.Count == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Top();
 * bool param_4 = obj.Empty();
 */