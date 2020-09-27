class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        char[] arrs = s.toCharArray();
        Arrays.sort(arrs);
        char[] arrt = t.toCharArray();
        Arrays.sort(arrt);
        
        // return Arrays.toString(arrs).equals(Arrays.toString(arrt));  8ms
        
        return Arrays.equals(arrs, arrt); //3ms

    }
}