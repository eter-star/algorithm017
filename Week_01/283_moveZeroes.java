class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int i = 0, j = 1;
        while(i < nums.length && j < nums.length){
            if(nums[i]== 0){
                if(nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;                
                }
                j++;
            }
            else{
                if(nums[j] == 0){
                    i++;
                    j++;
                }else{
                    i=j;
                    j++;
                }                
            }
        }
        
    }
}