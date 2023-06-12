# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        currentNode = self.root
        for character in word: # Simultaneously traverse the Trie and the given word to add the word to the Trie one character at a time.
            if character not in currentNode.children: # If the current character is not in the Trie already, add a new TrieNode to store it.
                currentNode.children[character] = TrieNode()

            currentNode = currentNode.children[character]

        currentNode.isWord = True # Set the last node in the sequence for this word to True to indicate that it marks the end of a word.

    def search(self, word: str) -> bool:

        # Use a DFS solution to search the Trie for matching words. We need to do this b/c of the .ab, ..ab, etc. and ab., a.., etc. cases. If we have dots in the given word, we have to search the entire Trie until we find a match or until we've checked the whole thing. If we fail to do this by checking only a single route, we will return False in cases where we should be returning True.
        def dfs(startIndex, root):
            currentNode = root

            for i in range(startIndex, len(word)): # Iterate over only the portion of the word that has not been searched for in the Trie yet.
                character = word[i] # Extract the current character from the word.

                if character == ".": # The dot character is our "recursive case." If we find one, we need to recursively search the Trie.
                    for child in currentNode.children.values():
                        if dfs(i + 1, child): # i + 1 to step down to the child node
                            return True # If we find a path that matches the given word, we return True. Otherwise, continue searching.
                    return False # If we don't find a matching route in the Trie, we return False.
                else: # Any character other than a dot means that we don't need to recursively search the Trie from the current node. Instead, we just traverse the Trie and word simultaneously to determine if the word is in the Trie or not.
                    if character not in currentNode.children: # If the current character is NOT in the Trie, we have no match. Return False.
                        return False
                    currentNode = currentNode.children[character]

            return currentNode.isWord # See notes below. The instructions explicitly state that you should igore whether a string in the Trie was added as a word or not. But the test suite states that we only return True if the search query was added to the Trie as a word.

        return dfs(0, self.root) # Call the dfs() function to start searching for the given word in the Trie.

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False
        
# ***** IDEAS *****
# IDEA 1:
# > We will need to use a Trie to do this.
#   > This means that we will need to write a node class to use to build the Trie.
# > TrieNode class:
#   > Each TrieNode will represent a character in the Trie.
#   > Additionally, each TrieNode will house a HashMap that maps characters (a-z) to other TrieNodes that are children of the current TrieNode.
#     > The HashMap of child TrieNodes will only contain (obviously) the TrieNodes for the characters that are present in the Trie. That is, if the "cat" is added to the Trie, the Root will contain children:{"c":TrieNode()}, the "c" TrieNode will contain children:{"a":TrieNode()}, the "a" TrieNode will contain children:{"t":TrieNode()}, while the 
# > Note: We do NOT need to keep track of which characters represent the ends of words. The specs state that we should be able to determine "if a string matches any previously added string." NOT, that we need to be able to find previously added words.
# > Note: The root node does NOT need to be associated with a specific character. That is, the root isn't mapped to a character. Instead, the root TrieNode contains a HashMap of characters (like all other nodes in the Trie) that specifies which characters are in the Trie as first characters in the strings in the Trie.
#   > That is, the root node jsut stores a list of characters that make up the beginnings of words/strings in the trie.
#   > This should not be a problem since our search() function will always be looking to see if the currentNode.children list contains the character we are looking for. We never check to see if the current TrieNode represents the current character.
# > Note: When in the instructions for this problem it states, "return True if there is any string in the data structure that matches word or false otherwise," it means to only return true if the specified word is a word in the Trie.
#   > That is, if you add "mad" and "bad" to the Trie then search for "ad," False will be returned. The instructions very clearly state that this case should return True, but it is just a poorly worded question. They are really asking you to only return True if the searched string was added in whole to the Trie as a word.