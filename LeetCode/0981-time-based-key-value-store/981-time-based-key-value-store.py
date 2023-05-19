class TimeMap:

    def __init__(self):
        self.timeKeys = {}
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key in self.timeKeys: # If the key is already in the Store, we only need to add the new entry.
            self.timeKeys.get(key).append((timestamp, value))
        else: # If the key is not in the Store, we need to make a new entry in the Store and create a new array to add the new entry to.
            self.timeKeys[key] = [(timestamp, value)]

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.timeKeys: # If the key is not in the Store, we return an empty string.
            return ""

        timestamps = self.timeKeys[key] # Get the array of timestamp-value pairs associated with the given key.

        if timestamp < timestamps[0][0]: # If the requested timestamp is smaller than the smallest timestamp in the list of timestamps for the given key, there will not be a smaller timestamp, so we return an empty string.
            return ""

        # Conduct binary search on the array to find the requested timestamp if it is present.
        left = 0
        right = len(timestamps) - 1
        
        while left <= right:
            mid = left + ((right - left) // 2)

            if timestamp < timestamps[mid][0]:
                right = mid - 1
            if timestamp > timestamps[mid][0]:
                left = mid + 1
            elif timestamp == timestamps[mid][0]: # There are two cases left if we reach this point: either we've found the timestamp we want or the timestamp isn't present. Thus, we need to check which case it is.
                return timestamps[mid][1]

        if timestamp < timestamps[mid][0]: # If the timestamp we are looking for is smaller than timestamp our binary search landed on, we return the next smallest timestamp's value.
            return timestamps[mid - 1][1]
        else: # If the timestamp we are looking for is larger than the timestamp our binary search landed on, we return the timestamp we landed on - it is the next smallest.
            return timestamps[mid][1]

# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)

# ***** IDEAS *****
# IDEA 1:
# > We can store the entries in a nested HashMap. One HashMap to store HashMaps for each of the keys. These sub-HashMaps will store all of the values and time stamps associated with a given key, with the time stamp as the key and the value as the value.
# > The only issue with this is that in the event that a requested (get()) key-timestamp pair is not in the Store, we have to return the value associated with the next largest timestamp.
#   > If we use this, we will only know that the requested timestamp is not in the inner HashMap. We still need a way to find the next smallest item in the HashMap.
# IDEA 2:
# > We can store the timestamp-value pairs in Lists (arrays) as the value for each key in a HashMap
# > Then, we can use binary search to find the desired HashMap in the array. If it isn't found we return the value just to the left of the point where the target is supposed to be.
#   > Will this work? Our search might land us in the wrong place...
# > This might work. When the requested timestamp isn't in the Store, depending on where our binary search lands, the final location of mid in the search might be either to the left or right of the requested timestamp. To get around this, we can check whether the final timestamp at mid is larger or smaller than the one we are looking for and return the appropriate timestamp based on this.