class Solution {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //Two-pass
        for(int i = 0; i < secret.length(); i++){
            int s = secret.charAt(i) - 48;
            int g = guess.charAt(i) - 48;
            if(s== g){
                a++;
            }
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }else{
                map.put(s, 1);
            }
        }        
        for(int j = 0; j < guess.length(); j++){
            int g = guess.charAt(j) - 48;
            if(map.containsKey(g)){
                b++;
                if((map.get(g) - 1) == 0 ){
                    map.remove(g);
                }else{
                    map.put(g, map.get(g) - 1);
                }
            }
        }
        b -= a;
                        
        StringBuilder sb = new StringBuilder();
        sb.append(a); 
        sb.append("A"); 
        sb.append(b); 
        sb.append("B");
        return sb.toString();
        
    }
}