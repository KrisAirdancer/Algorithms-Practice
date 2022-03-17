/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */

public class Solution : VersionControl {
    
    /// <summary>
    /// We cannot loop over this whole thing. It will take too long. O(N) though.
    /// 
    /// Use a modified binary search to find the first bad version.
    /// If bad, look in left partition (we are too far right)
    /// If good, look in right partition (we are too far left)
    /// Should work in O(logN) time
    /// <\summary>
    public int FirstBadVersion(int n) {
        
        // Call recursive method
        return BadVersionBinarySearch(0, n);
    }
    
    public int BadVersionBinarySearch(int left, int right) {
        
        // Calculate midpoint
        
        // If mid is bad && mid - 1 is good, return mid
        // If mid is bad, search left partition
        // If mid is good, search right partition
        
        int mid = left + ((right - left) / 2);
        
        if (IsBadVersion(mid) && !IsBadVersion(mid - 1)) {
            return mid;
        } else if (IsBadVersion(mid)) {
            return BadVersionBinarySearch(left, mid - 1);
        } else { // mid is good, therefore target version is in right partition
            return BadVersionBinarySearch(mid + 1, right);
        }
    }
}