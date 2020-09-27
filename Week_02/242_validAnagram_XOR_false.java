class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        char[] arrs = s.toCharArray();
        Arrays.sort(arrs);
        char[] arrt = t.toCharArray();
        Arrays.sort(arrt);
        
        int xor = 0;
        for(int i = 0; i < s.length(); i++){
            xor ^= arrs[i] ^ arrt[i];
            //if((arrs[i] ^ arrt[i]) == 0) return false;
        }
        
        return xor == 0? true : false;
    }
}

/// "aaaa" vs “bbbb”
/// "aaa"  vs "bbb"