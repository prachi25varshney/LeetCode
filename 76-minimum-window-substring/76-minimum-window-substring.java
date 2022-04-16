class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        HashMap<Character,Integer> tMap = new HashMap<>();
        HashMap<Character,Integer> sMap = new HashMap<>();
        String str = "";
        for(char ch : t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }
        
        int left=0, right =0,need = tMap.size(), have =0, min = Integer.MAX_VALUE;
        
        while(right<s.length()){
            while(have != need && right<s.length()){
                char ch = s.charAt(right);
                if(tMap.containsKey(ch)){
                    sMap.put(ch, sMap.getOrDefault(ch,0)+1);
                    if(sMap.get(ch).intValue() == tMap.get(ch).intValue()){
                        have++;
                    }
                }
                right++;
            }
            while(have== need){
                if(min>right-left+1){
                    str = s.substring(left,right);
                    min = right-left+1;
                }
                char ch = s.charAt(left);
                if(sMap.containsKey(ch)){
                    sMap.put(ch,sMap.get(ch)-1);
                    if(sMap.get(ch)<tMap.get(ch)){
                        have--;
                    }
                }
                left++;
            }
        }
        if(have==need && min>right-left+1){
            str = s.substring(left,right);
            min = right-left+1;
        }
        System.out.println(tMap+ "\n\n");
        System.out.println(sMap);
        return str;
    }
}