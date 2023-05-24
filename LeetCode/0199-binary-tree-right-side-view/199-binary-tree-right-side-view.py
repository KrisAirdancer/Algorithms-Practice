# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        visibleNodes = []
        nodes = collections.deque()

        if root:
            nodes.appendleft(root) # Push nodes onto the left of the queue.
        
        while nodes:
            levelLength = len(nodes) # The queue at this point will contian only the nodes from a single level, so we can get its length and use that to determine when we've reached the end of the current level when removing nodes from the queue - even while adding and removing nodes from the queue.
            for i in range(levelLength): # Loop over the portion of the queue that contains the nodes of the current level. That is, from the righthand side of the queue back X nodes, where X is the number of nodes in the current level.
                currentNode = nodes.pop() # Pop nodes from the right of the queue.
                
                if i == 0: # If this is the first node off of the queue for this level, it is the rightmost (visible) node. Add it to the output list.
                    visibleNodes.append(currentNode.val)
                
                # Push the children of the current node to the queue. Push right first to ensure that it is the first node to come off of the queue.
                if currentNode.right:
                    nodes.appendleft(currentNode.right)
                if currentNode.left:
                    nodes.appendleft(currentNode.left)

        return visibleNodes

# ***** IDEAS *****
# IDEA 1:
# > We need to return all of the nodes along the rightmost path of the tree, then we need to return all of the nodes on the rightmost path of the next subtree to the left of the rightmost one, but only the nodes at a deeper level than the lowest node in the path to the right of the current path.
# > The way a human might do this is to follow the rightmost path to its termination, then follow the next rightmost path from the point where the first path ended to its termination and so on.
#   > The problem with this is that we will need to return the leftmost paths when there is no rightmost path blocking them from view.
# 
# IDEA 2:
# > It might work to do a BFS traversal on the tree and return only the rightmost node in each level.
# > Since it is the rightmost node in each level that will be visible from the righthand side, this should work.
# > To do this, we will need to be able to figure out which node is the last in each level.
#   > We could do this easily by adding each node and its level as a tuple (node, level number) to a list then traversing the list and adding the last node in each group to the output list.
#   > That is, the BFS will add nodes to the queue (or an array) in groups of their level from left to right across the level. So we could just step over that list and look for the location where the level number chnages and take the node at that point.
#   > This is a two pass O(N) solution - O(2N). There should be a way to do this in O(1N) time - a single pass.
# > Ah! We can "peek" at the top element of the queue using myQueue[0].
#   > If we want to know if the node we just popped is the last one on the current level, we can peek the top of the queue to see what level it is at.
# > The only issue with this solution is that it is messy. Let's see if we can come up with something that doesn't require that we check the for the split points.
#   > If we could simply build a list of all of the nodes in each level, then take the rightmost element from each of those lists, it would cut out a lot of edge cases.
# 
# IDEA 3:
# > How do we differentiate between levels?
#   > NeetCode did this witout keeping track of the level of each node explicitly in his solution to LC 102, so I know it's possible.
#   > The way he did it is a bit hard to explain. An example is better.
# 
# ***** OUTLINE *****
# OUTLINE FOR IDEA 3:
# Instantiate a return list: visibleNodes
# Instantiate a deque() object: nodes
# Push the root node onto the nodes queue if it isn't None
# Loop over the nodes queue,
#     Get the length of the queue (the number of elements in it) - store this in a variable
#     Loop a number of times equal to the length of the current level (the length of the queue) (use an indexed for loop)
#         Pop the top of the queue: currentNode
#         If i == 0, # This is the rightmost node in this level
#             Add currentNode.val to the output list
#         Push the left and right children to the queue if they are non-None
#             Push right first
# Return the output list: visibleNodes
# 
# OUTLINE FOR IDEA 2:
# Instantiate a return list: rightmostNodes
# Instantiate a deque() object: nodes
# Push the root node to the queue if it is non-None
# Add the root node to the return list if it is Non-None
# Loop while nodes has elements:
#     Pop the top node from the queue to get the current node: currentNode
#     If currentNode is not root and currentNode.level != queue.peek().level:
#         Add the node on the top of the queue (NOT currentNode) to the return list (the currentNode is the leftmost node in the current level and we want the rightmost node)
#     Add the left and right children to the queue if they are Non-None
# Return the output list








