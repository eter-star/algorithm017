class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;  
        int bitIncrease = (digits[n - 1] + 1)/10 ;
        digits[n - 1] = (digits[n- 1] + 1) % 10;
        
        for(int i = n - 2; i >= 0 ; i--){
            digits[i] += bitIncrease;
            bitIncrease = digits[i] / 10;
            digits[i] %= 10;
        }
        
        if(bitIncrease == 1){
            int[] arr = new int[n + 1];
            for(int i = 1; i < n+1; i++){
                arr[i] = digits[i-1];
            }
            arr[0] = 1;
            return arr;
        }else{
            return digits;
        }
        
    }
}