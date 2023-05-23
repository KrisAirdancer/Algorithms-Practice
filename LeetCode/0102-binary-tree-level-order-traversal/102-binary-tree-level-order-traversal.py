# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        tList = [] # Our return list.
        nodes = deque()

        if root:
            nodes.appendleft((root, 0)) # Add new nodes to the left end of the queue.
        
        while nodes:
            currentNode = nodes.pop() # Remove nodes from the right end of the queue.

            # Add the current node to the return list.
                # Note that we will always be adding each level in order (that is, nodes from level 2 won't be added until all of the nodes from level 1 have been added). This means that if the index we are searching for is not in the output array, then it will be the next index that needs to be added. Ex. If we are looking for index 5, then we know that we have up to index 4 and can safely assume that if we add an element to the array, it will be at index 5.
            if currentNode[1] < len(tList): # The sub-array we are looking for exists, add the current node.
                tList[ currentNode[1] ].append( currentNode[0].val )
            elif currentNode[1] >= len(tList): # The sub-array we are looking for doesn't exist, create a new sub-array and add the current node.
                tList.append( [ currentNode[0].val ] )

            # Add the two children nodes to the queue.
            if currentNode[0].left:
                nodes.appendleft((currentNode[0].left, currentNode[1] + 1))
            if currentNode[0].right:
                nodes.appendleft((currentNode[0].right, currentNode[1] + 1))
        
        return tList

# ***** IDEAS *****
# IDEA 1:
# > This is just a simple level-order traversal of the tree. We simply need to traverse the tree using a Queue to get the nodes ordered correctly.
# > The trick with this one is that we need to return a list of lists such that each sublist represents a level in the tree.
#   > That is, we need to be able to figure out what level each node is in.
# 
# ***** OUTLINE *****
# > We can determine what level each node is in by adding each node to the queue as a tuple of (Node, level index).
#   > Each time we push a node to the queue, we calcuate it's level as the level of its parent + 1.
#   > The levels can be zero indexed so that they match the indexing of an array. This means that we can add each node to the correct array quickly and easily.
# > Note: Make sure to add the left child first, then the right child to the queue.
# 
# ***** PSEUDO-CODE *****
# Instantiate the return list: traversalList
# Instantiate a queue (deque() object)
# Push root to queue: (root, 0)
# While queue is not empty,
#     Pop the queue to get the current node
#     Add the current node to the traversalList: tList[currentNode[1]].append(currentNode[0])
#     Push the left and right children to the nodes list: nodes.append(currentNode, currentNode[1] + 1)
# Return tList
# 
# ***** PERFORMANCE *****
# Time Complexity: O(N) - We only need to visit each node in the tree once. But we must visit each node in the tree at least once.
# Memory Complexity: O(1) - An iterative solution will require no extra memory to traverse the tree.