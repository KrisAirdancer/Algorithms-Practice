"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        nodeMap = {} # A Dictionary to store mappings between the original list and the clone list nodes.
        cDummy = Node(0) # A dummy head for the clone list

        ogCurrent = head
        cCurrent = cDummy
        # Copy the original list, but don't include the random pointers (set them to None for now)
        while ogCurrent:
            # Create a new node to be added to the clone list.
            newNode = Node(ogCurrent.val, None, None)
            cCurrent.next = newNode # Add the new node to the clone list.

            # Create a mapping between the current OG node and the newNode.
            nodeMap[ogCurrent] = newNode

            # Step the nodes forward
            ogCurrent = ogCurrent.next
            cCurrent = cCurrent.next

        # Reset pointers
        ogCurrent = head
        cCurrent = cDummy.next
        # Connect the "random" pointers in the clone list
        while cCurrent:
            if ogCurrent.random is None:
                cCurrent.random = None
            else:
                # Get the random node from the original list.
                ogRand = ogCurrent.random
                # Get the node in the clone that corresponds to the ogCurrent.random node in the original.
                cRand = nodeMap[ogRand]
                # Set the random property of the current clone node.
                cCurrent.random = cRand
            
            # Step the pointers forward
            ogCurrent = ogCurrent.next
            cCurrent = cCurrent.next

        return cDummy.next

# ***** IDEAS *****
# IDEA 1:
# > If it was a normal singly linked list (nodes didn't have the "random" pointer), then we could simply loop over the input list and generate a new list with the same values as we went. That is, for each node in the input list, we create a new node and populate it with the data from the corresponding node in the input list.
# > Since the input list's nodes have a "random" pointer property, if we were to copy the list using the method above, we would not be able to connect the "random" pointers to the correct nodes in the list (or Null) because any "random" pointer pointing to a node that has not yet copied won't have anything to point to yet.
# > One solution to this would be to loop over the input list once and make a HashMap that contains mappings between the original node and the node that its "random" poionter points to. At the same time, we can create a copy of each of the pointed "random" nodes.
#   > The issue with this is that it is possible for more than one node to have "random" pointers to the same node. This method would result in a different copy being made for each of these.
#   > One workaround would be to check the hashmap for the existance of the node pointed to by the "random" pointer. But this will likely yield other issues and is likely more complicated than this needs to be.
# IDEA 2:
# > 1) Step over the input list and create a new linked list that is a copy of it, but initialize the "random" pointers of the new list to "None" for now.
#   > While doing this, create a mapping (HashMap) between each node in the input list and that node's copy in the clone list.
# > 2) Then, step over the two lists simultaneously and use the mapping between the two lists to determine where to point the "random" pointers of the clone list's nodes.
#   > That is, for a given node, get the node its "random" pointer points to; then use that node as the key to get the corresponding node in the clone list; and finally, set the "random" pointer of the current node in the clone list to that node.
#   > And of course, if the "random" pointer points to "None", just set the clone's "random" pointer to "None" and continue.
# ***** OUTLINE/PSEUDO-CODE *****
# Instantiate a Dictionary
# Instantiate dummy head for cDummy
# Instantiate ogCurrent = head (head can remain our pointer to the head of the original list)
# Loop over input list, (end loop when current pointer is None)
#     (Generate a new, clone, list of the original (with brand new nodes))
#     (No need to start at cList.next here b/c the first iteration of the loop will add the first node to the list by adding it at dummy.next)
#     Create a new node
#     Store the value in the original node in the clone
# Instantiate ogCurrent = head
# Instantaite cCurrent = cDummy.next
# Step over both lists, (end loop when current pointer is None)
#     (Remember to start the loop on cList.next)
#     If ogList.random = None: cList.random = None
#     Else,
#         Get node from ogList.random (ogRand)
#         Use ogList.random node (ogRand) as key in Dict to get the corresponding node in cList (cListTarget)
#         Set cList.random = cListTarget
# Return cList.next