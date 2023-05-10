class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top = 0
        bottom = len(matrix) - 1

        targetRow = -1

        # Search columns for a row that could contain the target

        while top <= bottom:
            mid = top + ((bottom - top) // 2)

            # Target is within current row
            if target >= matrix[mid][0] and target <= matrix[mid][len(matrix[mid]) - 1]:
                targetRow = mid
                break
            if target < matrix[mid][0]: # Target is in a row above the current row.
                bottom = mid - 1
            if target > matrix[mid][len(matrix[mid]) - 1]: # Target is in a row below the current row.
                top = mid + 1   

        # Search row for target
        
        left = 0
        right = len(matrix[0]) - 1

        while left <= right:
            mid = left + ((right - left) // 2)

            if target < matrix[targetRow][mid]: # Search left half
                right = mid - 1
            elif target > matrix[targetRow][mid]: # Search right half
                left = mid + 1
            else: # Target found
                return True

        return False

# ***** INPUTS *****
# > A 2D array of integers to be searched for the target.
# >> Each row is sortted in ascending order (smallest at left).
# >> Each column is sorted in ascending order (smallest on top).
# > An integer to be found in the 2D array.
# ***** OUTPUTS *****
# > True if target is in the 2D array; false otherwise.
# ***** IDEAS *****
# BFSol:
# > Run Binary Search on each of the rows. That is, for each row, run Binary Search.
# > This will find the target, but it will be O(M * log(N)), where M is the number of rows and N is the number of columns.
# BFSol Optimization 1:
# > We can do the same thing, but instead of running Binary Search on each row, we first run Binary Search on the first element of every column to find the row that will contain the target. We then run Binary Search on only that single row.
# > This solution should be O(logM) + O(logN) which is just O(logM + logN) = O(log(M * N)) as specified.
# ***** OUTLINE *****
# Conduct Binary Search on the "array" of columns.
# Conduct Binary Search on the row returned from the first Binary Search.
# Return the found index or -1 if target not in matrix.
# ***** PSEUDO-CODE *****
# top = 0
# bottom = len(matrix)
# mid = top + ((bottom - top) // 2)
# 
# Loop: While top <= bottom,
#     Calculate midpoint
#     Compare midpoint to target
#     If target less than midpoint