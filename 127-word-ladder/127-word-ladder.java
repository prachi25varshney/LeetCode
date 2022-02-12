class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size() == 0 || !wordList.contains(endWord))
            return 0;
        HashSet<String> set = new HashSet();
        for(String word:wordList){
            set.add(word);
        }
        int cnt = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        set.remove(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                char[] curr = queue.poll().toCharArray();
                for(int j=0;j<curr.length;j++){
                    char tmp = curr[j];
                    for(char c = 'a';c<='z';c++){
                        if(c==tmp) continue;
                        curr[j] = c;
                        String nword = new String(curr);
                        if(set.contains(nword)){
                            if(nword.equals(endWord)) return cnt+1;
                            queue.add(nword);
                            set.remove(nword);
                        }
                    }
                    curr[j] = tmp;
                }
                
            }
            cnt++;
        }
        return 0;
    }
}