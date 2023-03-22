class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

# OUTLINE
# Instantiate a HashMap<HashSet> for the rows - Key: row index, Value: HashSet
# Instantiate a HashMap<HashSet> for the columns - Key: col index, Value: HashSet
# Instantiate a HashMap<HashSet> for the blocks - Key: (row/3, col/3), Value: HashSet
# Loop over the input array row-wise (for each row, visit each element)
#     Pull current element into a variable: currentElement
#     If currentE is "" (an empty space),
#         continue
#     If currentE is in rows set (if currentE in rows[row])
#         return False
#     Else
#         Add currentE to rows set
#     If currentE is in cols set (if currentE in cols[col])
#         return False
#     Else
#         Add currentE to cols set
#     If currentE in blocks set (if currentE in blocks[(row/3, col/3)])
#         return False
#     Else
#         Add currentE to blocks set
# return True (If we make it through all of the elements without encountering a duplicate, the board is valid)


# Time Spent: 
# >> March 20, 2023: 36 min
# >> March 21, 2023: 32 min
# >> March 22, 2023: 25 min
# Inputs:
# > Each cell in the sudoku board can contain one of 9 (not 10) values: 1-9 (NOT 0-9).
# *** NeetCode Solution *** 
# > Use a unique HashSet for each row and a unique HashSet for each column
# >> We then loop over every row and add the values to the HashSet for that row. If the set already contains the value we want to add, then we return False b/c we have found a duplicate in a row/column.
# >> For the blocks we have to be a bit more clever.
# >>> We will also make a HashSet for each of the blocks (9 HashSets total) and we will also iterate over the elements in each block and check-then-add each element to the HashSet for the current block. However, where we have to be clever is with the indexing. We have to know which block a given element belongs in. To do this, we can divide the row and column indices of the element by 3 (the number of columns and rows) to get the index. Because integer division rounds down (in Python at least - doesn't round, it truncates), we will consistantly get the index we want. That is elements in rows 0-2 (the first three) will be 0/3 = 0, 1/3 = .333 => 0, and 2/3 = .667 => 0.
# > One final detail. We need to be able to map the elements in the Sudoku grid to the correct HashSet. To do this, we can store all of the HashSets in HashMaps: One map for the rows, one for the columns, and one for the blocks. For the rows and columns, the Key will be the row/column index. For the blocks HashMap, the Key will be a tuple (a pair) such that (row / 3, column / 3).
# >> This will allow us to easily access the correct HashSet for each element in O(1) time.
# > Optimization:
# > We don't have to iterate three times, once for the rows, once for the columns, and once for the blocks. Istead, we can just loop over all of the elements once and for each element, check the HashSet for the row, column, and block that it corresponds to all at once in each iteration.
# > Time Complexity:
# >> Checking each row and each column individually will take O(N) time each. Thus doing both separately would take 2xO(N) time.
# >>> Note: Python's Set.add() function does NOT return anything. So we have to check BEFORE we add the element to see if it is already there.
# >> But since the input size is always a 9x9 grid, will it just be constant no matter what our solution is?
# >>> Mostly right. Since there are 9 rows and 9 columns and we have to loop over all of them at least once (if we're clever) if not twice, it'll take O(9^2) time regardless of the input. So kinda O(1), but not reallyish.
# > Memory Complexity:
# >> Since we have to make 9 HashSets for the rows and 9 HashSets for the columns and 9 HashSets for the blocks, all of which have 9 items (integers), we end up with O(9^3) memory complexity as well.
# Ideas
# > Each box, column, and row must have a sum of 1 + 2 + ... + 8 + 9 = 45
# >> So all we really need is an efficient way to keep track of the sums of the values in each block, row, and column as we loop over the input array. This will allow us to loop over the input only once, thus giving us a time complexity of O(N).
# >>> So our BCR is O(N). It is O(N) b/c we have to visit each element at least once, so we can't go any lower than O(N).
# >> We don't even need to know which row/column has which value, all we need to know is if any of them have a sum other than 45.
# >> We could simply use three arrays that store the sums of each row, column, and block.
# >>> Three arrays of length 9 where the index in the array is the index of the row/column/block (eg. row 0's sum is stored in rowSums[0])
# >>> Okay. Now what's wrong with this solution? Anything?
# >>> One tricky spot is determining which block we are in.
# >>>> We could loop block-wise, but that would result in slow memory accesses. We want to loop row-wise.
# >>>> We could just check, if i is in 0-2 => block 1; if i is in 3-5 => block 2; etc. But this seems clunky. There should be a way to calculate which block we are in.
# > What is the brute force solution here?
# >> BFSol is to loop over each row and sum up the elements in them. If any row sums to something other than 45, we return false. We then do this for the columns and the blocks.
# >> This solution is not great b/c it is O(N^3) and requires akward array accesses.
# Wait... Neither of these solutions work...
# >> It is possible that other combinations of 9 values sum to 45 as well as 1-9. Thus, there could be false positives.
# >> Instead, we are going to have to keep track of "character" (number) counts for each row, column, and block.
# >> A HashMap might be good for this, but it seems as though we would need a lot of HashMaps to do it.
# >> We could use a HashMap<row/col/block index, counts[9]> to store the number counts of each row/column.
# > Wait wait wait... Start over and follow your system. This is twice you've started trying to solve the wrong problem.
# >> This problem is asking you to validate a PARTIAL Sudoku board. Not a completed one.
# >> This means that we probably only need to check for duplicates in each row/column/block. If there are duplicates, then that row/column/block won't be valid.
# >> In this case, we could do the same thing and loop over the rows and keep track of the counts on each row, column, and block. While we are adding values to the counts array, we check to see if any of the counts exceed 1. If this is the case, we return False early.