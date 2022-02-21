using System;

/// <summary>
/// HackerRank Utopian Tree
/// </summary>
public class utopian_tree
{
    public static int utopianTree(int n) {

        // Doubles in the spring (odd case)
        // Grows by 1 in the fall (even case)
        // Starts @ the beginning of spring (first cycle in our sim is a doubling)

        // int height - current height of the tree
        // for loop - start at i = 1 and go to i == n
        // if i is odd (as 1 will be), double height
        // if i is even, add 1 to height

        int height = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) { // Odd case
                height *= 2;
            } else { // Even case
                height += 1;
            }
        }
        return height;
    }
}
