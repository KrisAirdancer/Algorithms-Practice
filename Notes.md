class LRUCache:

    def __init__(self, capacity: int):
        # Initialize maxCapacity to "capacity"
        # Initialize currentCapacity to 0
        # Initialize the first node in the Linked List
        
    def get(self, key: int) -> int:
        

    def put(self, key: int, value: int) -> None:

class Node:
    # Need to store the value, next, and previous
    def __init__(self, key: int=0, value: int=0, prev: Node=None, next: Node=None):
        self.key = key
        self.val = value
        self.prev = prev
        self.next = next
        
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

# ***** IDEAS *****
# IDEA 1: 
# > It seems like we could just use a HashMap for this.
# > I can't see anything wrong with this in terms of the problem requirements, but I get the feeling that it won't work in the end.
# IDEA 2:
# > Could use a doubly linked list.
# > Add new items to the head and remove old ones from the tail. Both of these operations would be O(1) time complexity, but accessing items in the linked list would be O(N) time.
# > However, we could implement the linked list as an array where each entry stores a sub-array of four values (integers): [key, value, next, prev].
#   > The problem with this is that there is no way to use the key (given in get()) to access a specific element in the array.
# > Oh! Wait. The hard part of this problem is keeping track of the least recently used item in the cache.
#   > This means that we can use the HashMap solution to store items in the "cache" and we use a linked list to keep track of which items were added when.
# NEETCODE:
# Create a HashMap where the value of each entry is a pointer to a node in a linked list.
# The head of the linked list is the least recently used item and the tail is the most recently used item.
# We will need to create our own node class.
# The nodes will need to be doubly linked.
# ***** OUTLINE 1 *****
# __init__()
# Initialize a HashMap
# Initialize the first node of the Linked List
# Initialize a variable to store the maximum capacity: maxCapacity (initialize to "capacity") (the maximum number of items that can be kept in the cache simulteneously)
# Initialize a variable to keep track of the current capacity: currentCapacity (initialize to zero (0))
# 
# get()
# Check if the specified key is in the HashMap,
#     If it is, return the associated value
#     Else, return -1
# 
# put()
# 
# If the current capacity is below that of the maxCapacity,
#     Add the key-value pair to the HashMap
#     Add a node to the tail of the LinkedList