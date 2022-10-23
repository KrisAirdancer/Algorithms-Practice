class Solution {
    
    public int addDigits(int num) {
        
        int copy = num;   
        int result = num;
        
        while (copy > 9) {
            
            result = 0;
            
            while (copy > 0) {
                
                result += copy % 10;
                copy = copy / 10;
            }
            
            copy = result;
        }
        
        return result;
    }
}