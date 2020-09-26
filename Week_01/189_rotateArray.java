class Solution {
    public void rotate(int[] nums, int k) {
        k = k% nums.length;
        if(k == 0 ) return;
        int j = 0;
        int gcd = gcd(nums.length, k);
        while(j++ < gcd){
            int prev = nums[j];
            int count = 0;
            for(int i = j; count++ < nums.length/gcd; i+=k){
                int tmp = nums[(i+k) % nums.length];
                nums[(i+k) % nums.length] = prev;
                prev = tmp;
            }
        }

    }

    public int gcd(int a, int b){
        while(a != b){
            if(a > b){ a = a-b; }
            else{ b = b-a;}
        }
        return a;
    }
}