class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) < 2:
            return 0
        
        maxProfit = 0
        left = 0
        right = 1

        while right < len(prices):
            profit = prices[right] - prices[left]

            if profit > maxProfit:
                maxProfit = profit
            
            if prices[right] < prices[left]:
                left = right
            
            right += 1

        return maxProfit

# IDEAS
# > BFSol
# >> The brute force solution would be to calculate every possible combination of profits, then select the hightest among them. Ex. Loop over the array, and for each element, check the profit that can be made from the current item and all other items to the right of it. This would get us the right answer, but would take O(N^2) time.
# > BCS
# >> The best concievable solution is one that runs in O(N) time, because hypothetically, we should be able to visit every element in the list only once.
# > Option 1
# >> We loop over the array with two pointers: left and right. On each iteration, we 1) calculate the profit for that pair of days, then 2) check if the element at left is less than the element at right, if it is, we set right = left.
# >> Note: We loop over the array with left and use right to keep track of our current minimum.
# >> We keep track of the maxProfitSoFar in a variable outside the loop and return it after the loop completes.
# >> If the number (len()) of prices is less than 2 (only one item in the list), return 0
# >> Initialize maxSoFar to 0
# > Time complexity: O(N) - Since we only need to iterate over the list once (we only visit each element once - with a few visited twice by the "left" pointer), we are running in O(N) time.
# > Memory Complexity: O(N) - Since we only need to store the input array and a few variables, memory complexity is O(N).
# OUTLINE
# If prices.length < 2, return 0
# Instantiate maxProfitSoFar to 0
# Instantiate left = 0 and right = 1
# Loop: While right < prices.length,
#     Calculate current profit as prices[right] - prices[left]
#     If currentProfit > maxProfitSoFar,
#         Set maxProfitSoFar = currentProfit
#     If prices[right] < prices[left],
#         Set left = right
#     right++
# Return maxProfitSoFar