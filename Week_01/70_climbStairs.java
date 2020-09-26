class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairsAux(n, 2 , 1); 
    }
    
    public int climbStairsAux(int n, int nMinusOne, int nMinusTwo){
        if(n < 3) return nMinusOne;
        return climbStairsAux(n-1, nMinusOne + nMinusTwo , nMinusOne);
    }
}