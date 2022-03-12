public class Solution {
    
    /// <summary>
    /// Solution from Nick White's YouTube channel: https://www.youtube.com/watch?v=OEW50g03mT0&ab_channel=NickWhite
    /// </summary>
    public string AddBinary(string a, string b) {
        
        StringBuilder builder = new StringBuilder();
        int a_index = a.Length - 1;
        int b_index = b.Length - 1;
        int carry = 0;
        
        while (a_index >= 0 || b_index >= 0) {
            int sum = carry; // "Adding" the carry to the sum
            // Converting the current digits to ints
            if (a_index >= 0) { sum += a[a_index] - '0'; }
            if (b_index >= 0) { sum += b[b_index] - '0'; }
            
            // If 0+0, append 0; if 0+1, append 1; if 1+1, append 0 (next step carries); if 3 b/c +carry, append 1 and 1 will be carried in next step
            builder.Append(sum % 2);
            // If 0+0, carry is 0; if 1+0, carry is 0 (int division); if 1+1, carry is 1; if 3 b/c of +carry, carry is 1
            carry = sum / 2;
            
            a_index--;
            b_index--;
        }
        if (carry != 0) { builder.Append(carry); }
        
        StringBuilder reversed = new StringBuilder();
        for (int i = builder.Length - 1; i >= 0; i--) {
            reversed.Append(builder[i]);
        }
        return reversed.ToString();
    }
}