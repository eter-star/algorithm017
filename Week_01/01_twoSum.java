class Solution {
    public int[] twoSum(int[] nums, int target) {
        //One-pass hashmap on premise that there exist only one solution
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i < nums.length; i++){
            int completment = target - nums[i];
            if(map.containsKey(completment)){
                return new int[]{i, map.get(completment)};
            }
            map.put(nums[i], i);
        }
        return null;        
    }
}