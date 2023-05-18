class Node:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value

        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        # Initialize maxCapacity to "capacity"
        # Initialize currentCapacity to 0
        # self._head = None
        # self._tail = None

        self.cache = {}
        self.maxCap = capacity
        self.currentCap = 0
        self.head = None
        self.tail = None
        
    def get(self, key: int) -> int:
        # If head == None,
            # Return -1
        # If key not in HashMap,
            # Return -1

        # If list is of length 1,
            # Do nothing. (there's nothing to swap)
            # Return
        # If list is of length 2,
            # Swap the head and tail pointers
            # (do nothing else. since this is a doubly linked list, if it is of length two it is "symmetrical")
            # Return
        # (if above two cases don't trigger, list is of length 3 or greater)
        
        # If node is head,
            # Move node from head of list to tail of list.
        # If node is tail, (don't implement this case)
            # Do nothing. Node is already in MRU position.
        # Else,
            # Cut the associated Node out of the Linked List and append it to the tail of the Linked List (this to update the "use" status)

        # Return the associated value

        if self.head is None:
            return -1
        if key not in self.cache.keys():
            return -1

        if self.currentCap == 1: # List of length 1
            return self.cache[key].value
        elif self.currentCap == 2: # List of length 2
            # temp = self.head
            # self.head = self.tail
            # self.tail = temp
            # +++++
            self.head.prev = self.tail
            self.head.next = None
            self.tail.prev = None
            self.tail.next = self.head
            temp = self.head
            self.head = self.tail
            self.tail = temp
            return self.cache[key].value

        if self.cache[key] is self.head:
            temp = self.head.next
            self.head.next.prev = None
            self.head.next = None
            self.head.prev = tail
            self.tail.next = head
            self.head = temp
            self.tail = self.tail.next
        else:
            target = self.cache[key]
            prev = target.prev
            next = target.next
            prev.next = next
            next.prev = prev
            self.tail.next = target
            target.next = None
            target.prev = self.tail
            self.tail = target

        return self.cache[key].value

    def put(self, key: int, value: int) -> None:
        # If currentCapacity >= maxCapacity, (we need to evict a Node before adding)
            # If head.next == None && head.prev == None, (list of length 1)
                # Set tail = None
                # Set head = None
            # Else, (list of length 2 or greater)
                # Remove the Node at the head of the Linked List
            # Decrement currentCapacity
            
        # Create a new Node with the key-value pair
        # Store the new Node in the HashMap (key = key, value = new Node)
            # Note that the new Node will contain both the key and the value. The key will be stored in two places.
        # If self.head == None,
            # Set head = nNode
            # Set tail = nNode
        # Else,
            # Append the new Node to the end (tail) of the Linked List
            # Set tail = nNode
        # Increment currentCapacity

        # Evict LRU node.
        if key in self.cache:
            print("KEY FOUND")
        else:
            print("KEY NOT FOUND")
            
        if key not in self.cache and self.currentCap >= self.maxCap:
            print("evicting: ", self.head.value)
            print("currentCap: ", self.currentCap)
            self.cache.pop(self.head.key)
            # if self.head.next is None and self.head.prev is None: # List of length 1
            if self.currentCap == 1 and self.maxCap == 1: # List of length 1
                self.tail = None
                self.head = None
            else:
                print("head.value: ", self.head.value, ", tail.value: ", self.tail.value)
                print("NEXT: ", self.head.next)
                self.head = self.head.next # Move head pointer forward to next node in list.
                # print("head.prev: ", self.head.prev.value)
                self.head.prev.next = None # Set the next pointer of the old head to None.
                self.head.prev = None # Set the prev pointer of the new head to None (this disconnects the old node from the list).

            self.currentCap -= 1

        # TODO:
        # If key not in cache, add it (and a node to the linked list)
        # Else, update the existing entry in the cache dictioanry and update linked list to have modified entry at front of list

        newNode = Node(key, value) # Create a new node for the linked list.
        self.cache[key] = newNode # Add the new node to the cache HashMap.

        print("putting: ", newNode.value)
        if self.head is None: # Cache is empty
            self.head = newNode
            self.tail = newNode
        else:
            self.tail.next = newNode # Point the end of the list at the new node.
            newNode.prev = self.tail # Point the new node at the end of the list.
            self.tail = self.tail.next # Make the new node the tail of the list.

        print("head: ", self.head.value, ", tail: ", self.tail.value)
        
        self.currentCap += 1

# Edge Cases
# > How do we add the first node to the list?
#   > Do we do this in the constructor or in the put() method?
# > How do we handle a put() operation when there is only one node in the list?
#   > This should be easy to handle, we just append as normal.
# > How do we handle a put() operation when there are no nodes in the list?
#   > If there aren't any nodes in the list, we will need to create the list. This will either be done by the constructor or by the put() function.
# > How do we handle a get() operation when there is only one node in the list?
#   > If we try to splice the node out and append it to another, we will get errors when trying to access the other non-extant nodes.




        
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