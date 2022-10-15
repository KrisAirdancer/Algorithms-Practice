
/**
 * IDEA:
 * - Push() adds elements to inputStack. When Pop()/Peek() is called and outputStack is empty,
 *   all elements from inputStack are moved to outputStack. If outputQueue isn't empty when
 *   Pop()/Peek() is called, don't move all items, instead, return the top item on outputStack.
 * 
 * EDGE CASES:
 * - Can't think of any at the moment
 * 
 * PERFORMANCE:
 * - Time Complexity: 
 * - Memory Complexity: 
 */
public class MyQueue {
    
    Stack<int> inputStack;
    Stack<int> outputStack;

    public MyQueue() {
        
        inputStack = new Stack<int>();
        outputStack = new Stack<int>();
    }
    
    public void Push(int x) {
        inputStack.Push(x);
    }
    
    public int Pop() {
        if (outputStack.Count == 0) {
            
            while (inputStack.Count > 0) {
                outputStack.Push(inputStack.Pop());
            }
            
            return outputStack.Pop();
            
        } else {
            
            return outputStack.Pop();
        }
    }
    
    public int Peek() {
        if (outputStack.Count == 0) {
            
            while (inputStack.Count > 0) {
                outputStack.Push(inputStack.Pop());
            }
            
            return outputStack.Peek();
            
        } else {
            return outputStack.Peek();
        }
    }
    
    public bool Empty() {
        return inputStack.Count == 0 && outputStack.Count == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Peek();
 * bool param_4 = obj.Empty();
 */













