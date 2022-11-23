class Solution
{
    // Loop over sentences[]
        // Loop over each sentence and count the number of spaces
        // The number of spaces + 1 is the number of words in the sentence
        // If the sentence count is larger than the stored currentMax, update currentMax
    // Return currentMax
    public int mostWordsFound(String[] sentences)
    {
        int maxWordCount = 0;
        
        for (String sentence : sentences)
        {
            int wordCount = 0;
            
            for (int i = 0; i < sentence.length(); i++)
            {
                if (sentence.charAt(i) == ' ')
                {
                    wordCount++;
                }
            }
            
            wordCount++;
            
            if (wordCount > maxWordCount)
            {
                maxWordCount = wordCount;
            }
        }
        
        return maxWordCount;
    }
}