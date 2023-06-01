# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
class Trie:

    def __init__(self):
        # Initialize root node
        self.root = TrieNode()
        self.root.isWord = True

    def insert(self, word: str) -> None:
        currentNode = self.root
        for i in range(len(word)): # Loop over the Trie and word simultaneously to insert the given word.
            character = word[i]
            if character not in currentNode.characters: # If no node for the current character exists, add one.
                currentNode.characters[character] = TrieNode()
            currentNode = currentNode.characters[character] # Step to the next node in the Trie.

        currentNode.isWord = True # Current node should already be set to the final node in the word.

    def search(self, word: str) -> bool:
        currentNode = self.root
        for i in range(len(word)): # Loop over the Trie and word simultaneously to determine if the word is in the Trie.
            character = word[i]
            if character not in currentNode.characters: # If no node exists for the current character, the word is not in the Trie.
                return False
            else: # If a node does exist for the current character, step to the next node.
                currentNode = currentNode.characters[character]

        # currentNode should already be set to the final node in the word. Thus, if we return current.isWord, we will return True if the word was previously inserted.
        return currentNode.isWord

    def startsWith(self, prefix: str) -> bool:
        currentNode = self.root
        for i in range(len(prefix)): # Loop over the Trie and the prefix simultaneously to check the prefix for the Trie.
            character = prefix[i]
            if character not in currentNode.characters: # If the current character is not in the Trie, the prefix is not in the Trie.
                return False
            else: # The current character is in the Trie, step to the next node.
                currentNode = currentNode.characters[character]
        
        return True

class TrieNode:

    def __init__(self):
        self.isWord = False
        self.characters = {}
        
# ***** IDEAS *****
# IDEA 1:
# > This is just like we built in J's class. We need to make a tree (nodes) where each node stores an array (or HashMap) of characters (a-z) that are used to map to the next node in a given word (Ex. If the trie contains "apple" and "ant", the "a" node's HashMap would be {"a":TrieNode(), "n":TrieNode()}, where the TrieNodes are the next nodes in the tree.). Each node will also need to have a boolean value to specify if that node represents the end of a word or not (Ex. The "t" node in "cat" would be marked "True").
# > For startsWith(), can use a while loop to step through the tree until the end of the given prefix is reached. If a None node is encountered during the traversal, return False; else, if the loop completes, return True.
# > TrieNode()
#   > isWord: bool
#   > characters: HashMap