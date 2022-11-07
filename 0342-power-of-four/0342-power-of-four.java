class Solution {
    
    public boolean isPowerOfFour(int n) {
        
        double result = Math.log10(n) / Math.log10(4);
        
        System.out.println("result: " + result);
        System.out.println("% 1: " + result % 1);
        
        return (result % 1) == 0;
    }
}