class Solution
{
    public int numJewelsInStones(String jewels, String stones)
    {
        int count = 0;
        
        HashSet<Character> jewelStones = new HashSet<Character>();
        
        for (int i = 0; i < jewels.length(); i++)
        {
            char jewel = jewels.charAt(i);
            
            System.out.println(jewel);
            
            jewelStones.add(jewel);
        }
        
        System.out.println("BREAK");
        
        for (int i = 0; i < stones.length(); i++)
        {
            char stone = stones.charAt(i);
            System.out.println(stone);
            
            if (jewelStones.contains(stone))
            {                
                count++;
            }
        }
        
        return count;
    }
}