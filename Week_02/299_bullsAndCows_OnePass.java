class Solution {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //One-pass
        for(int i = 0; i < secret.length(); i++){
            int s = secret.charAt(i) - 48;
            int g = guess.charAt(i) - 48;
            if(s== g){
                a++;
            }else{
                if(map.getOrDefault(s, 0) < 0){
                    b++; //guess contains more s char than secrets
                }
                if(map.getOrDefault(g, 0) > 0){
                    b++; //secret contains more g char than guess
                }
                map.put(s, map.getOrDefault(s, 0) + 1);
                map.put(g, map.getOrDefault(g, 0) - 1);
            }
        }                                
        StringBuilder sb = new StringBuilder();
        sb.append(a); 
        sb.append("A"); 
        sb.append(b); 
        sb.append("B");
        return sb.toString();
        
    }
}