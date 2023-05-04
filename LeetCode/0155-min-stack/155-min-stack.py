class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        if not self.stack: # Stack is empty
            self.stack.append( (val, val) )
        else:
            if val < self.stack[-1][1]:
                self.stack.append( (val, val) )
            else:
                self.stack.append( (val, self.stack[-1][1]) )

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# ***** IDEA *****
# Each value will be stored in the array as a tuple of (value, currentMin).
# > We are essentially going to keep track of the smallest value seen so far.
# > When we add a value that is smaller than the current minimum, we store it as the currentMin in the tuple.
# > When we add a value that is greater than or equal to the current minimum, we store the previous item's currentMin value in the new tuple.
# > When getMin() is called, we return 


# Questions to ask when devising a solution:
# - What data can I store?
#     - Will doing so make the alg faster? (storing intermediate values - ex. Recalculations or preventing searching for something)
#     - Will doing so reduce duplicated work?
#     - Will doing so clean up the code?
#     - Can I store intermediate values?
