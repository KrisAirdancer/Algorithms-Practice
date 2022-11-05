class Solution {
    
    /**
     * IDEA:
     * - Since you can take either 1, 2, or 3 stones from the pile and the winner is the player that removes
     *   the last stone, you will only lose the game if the number of stomes you have to choose from is
     *   divisible by 4. That is, if there are 4 stones left, you will leave either 3, 2, or 1 stone for
     *   your opponent, which allows them to win the game. However, if there are 5 stones, you can leave
     *   4, putting your opponent in the same position. If there are 3 stones, you can take all of them
     *   and win the game right then and there.
     *   Thus, if the number of stomes n is divisible by 4, you cannot win; otherwise, you can win.
     * 
     * SOURCE:
     * - Read through the provided solution to understand the logic of the problem: https://leetcode.com/problems/nim-game/solution/
     * 
     */
    public boolean canWinNim(int n) {
        // As long as the number of stones n is not evenly divisible by 4, you can win the game.
        return (n % 4) != 0;
    }
}