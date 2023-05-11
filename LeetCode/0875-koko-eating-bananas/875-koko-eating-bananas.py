class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # left and right are NOT pointers to indexes in an array. Instead, they are the kValues list (the list of possible k values).
            # We don't need an actual list b/c as we conduct our binary search, anything that is ruled out as an option, doesn't need to be retained. We can just change left and right to be the bounds of the range of k values we want to consider.
        left = 1
        right = max(piles) # O(N)

        # Initialize to right because right is the largest pile (number of bananas in a pile) in the input array, which means that this value will at least work. It just won't necessarily be the slowest speed.
            # That is, since we are guaranteed that the number of piles will always be less than the number of hours the guard will be away. This means that if we choose the size of the largest pile as our rate/hour, we will be guaranteed to eat all of the piles. However, we won't necessarily eat all of the piles in the slowest possible time. Thus, this is an acceptable starting piont for our return value - it will be a valid return value - it just might not be the correct return value.
        smallestSoFar = right

        # Binary Search
        while left <= right:
            mid = left + ((right - left) // 2)
            # Calculate the number of hours needed to eat all of the bananas at the currnet rate/hr k.
            hoursToEat = 0
            for pile in piles:
                hoursToEat += ceil(pile / mid) # We don't do integer division here b/c we want to round up to the next integer and Python's integer division truncates. ceil() rounds up.
            print(hoursToEat)

            # If the number of hours taken to eat all of the bananas is less than the time the guard is away, we want to DECREASE the eating speed so that we take longer to eat all of the bananas. This means that we will need to search the LEFT half of the "array."
            if hoursToEat <= h: # Note that we also include rates for k that allow us to eat all of the bananas in exactly the same time as the guard will be away since he isn't gonig to stop us if we swallow the last banana right as he walks in.
                right = mid - 1
                # Since coming in under time is acceptable, we also store the current value in case this is the best we can do.
                smallestSoFar = mid
            # If the number of hours taken to eat all of the bananas is greater than the number of hours the guard is away, we won't be able to eat all of the bananas in time. Thus, we need to INCREASE our eating speed by searching the RIGHT half of the "array."
            if hoursToEat > h:
                left = mid + 1
            
        return smallestSoFar

#  __(.)<
#  \___)
# Yes, this is necessary for this code to work.

# ***** IDEAS *****
# NeetCode
# > O(maxCountInPiles * numOfPiles)
# We are guaranteed that the number of hours is no smaller than the number of piles. Because of this, we can start at 1 (the lowest possible value for k) and iterate over the list of piles and count up how many hours it would take us to eat all of the bananas. If it takes more than h hours to eat all of the bananas, we increment k by one and repeat the hours calculation. We repeat this process until we find a value that is able to eat all of the bananas in the given amount of time h.
# > This solution will be O(maxCountInPiles * numOfPiles) because we will (in the worst case) have to iterate over all posissible values of k from 1 to the maximum value in the piles list. Thus, the time complexity would be O(maxCountInPiles * numberOfPiles).
# > We can do better than this.
# > An alternative approach is to use the same approach, but instead of checking every value of k from 1 to maxAmountInPiles, we can use Binary Search over the possible values of k. For each value of k visited by the Binary Search alg, we calculate the number of bananas we'd be able to eat in the given timeframe h for that value of k. If we are able to eat all of the bananas in the timeframe, we step down to a lower value of k (go left); if we aren't able to eat all of the bananas, we step up to a higher value of k (go right).
# >> This approach will result in a time complexity of O(log(max(numInPiles)) * numOfPiles). This isn't amazing performance, but it is much better than the other implementation.
# ***** OUTLINE *****
# Find the maximum value in piles: maxBananas
# Generate a list of integers in increments of one from 1 to maxBananas: kValues
# Instantiate smallestSoFar
# Binary search to find the smallest value of k
#     Instantiate left = 0, right = len(kValues) - 1
#     Loop: While left <= right,
#         Calculate midpoint of kValues
#         Calculate the number of bananas we'd be able to eat with that value of k: numBananasEaten (use a helper function)
#         If numBananasEaten > totalBananas,
#             Update smallestSoFar
#             Search left half (k is too big)
#         If numBananasEaten < totalBanans,
#             Search right half (k is too small)
# Return smallestSoFar