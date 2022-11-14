class Solution
{
    public String defangIPaddr(String address)
    {
        StringBuilder defangedIP = new StringBuilder();
        
        for (int i = 0; i < address.length(); i++)
        {
            char current = address.charAt(i);
            
            if (current == '.')
            {
                defangedIP.append("[.]");
            }
            else
            {
                defangedIP.append(current);
            }
        }
        
        return defangedIP.toString();
    }
}