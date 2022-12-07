class Solution
{
    public String interpret(String command)
    {
        StringBuilder parsed = new StringBuilder();
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < command.length(); i++)
        {
            char current = command.charAt(i);
            
            if (current == 'G') // Process G as its own token
            {
                parsed.append('G');
            }
            else if (current == ')') // Token built, parse it and append correct characters to output
            {
                token.append(current);
                
                String tokenStr = token.toString();

                switch(tokenStr)
                {
                    case "()":
                        parsed.append('o');
                        break;
                    case "(al)":
                        parsed.append("al");
                        break;
                }

                // Reset token
                token = new StringBuilder();
            }
            else // Append current character to token
            {
                token.append(current);
            }
        }

        return parsed.toString();
    }
}