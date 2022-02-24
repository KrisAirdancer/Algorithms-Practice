public class Solution {
    public bool IsValid(string s) {
        
        if (s.Length == 1) { return false; }
        
        Stack<char> stack = new Stack<char>();
        
        for (int i = 0; i < s.Length; i++) {
            
            char token = s[i];
            Console.WriteLine(token);
            if (token == '(' || token == '[' || token == '{') {
                stack.Push(token);
                
            } else { // token is closed paren or invalid character
                
                if (stack.Count == 0) { return false; }
                
                char last = stack.Pop();
                
                if (last == '(' && token != ')') { return false; }
                else if (last == '[' && token != ']') { return false; }
                else if (last == '{' && token != '}') { return false; }
            }
        }
        if (stack.Count > 0) {
            return false;
        } else {
            return true;
        }
    }
}