class Solution {
    LinkedList<String> q = new LinkedList<>();
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)){
           return 0; 
        }
        
        HashSet<String> wordSet = new HashSet<>(wordList);

        int ans = 0;
        q.add(beginWord);
        
        // BFS 
        while(!q.isEmpty()){
            
        int size = q.size();
            
           for(int i = 0 ; i < size ; i++){
               
                String currWord = q.remove();
               
                if(currWord.equals(endWord)) return ans+1;
               
                // Generate all valid sequence and add to Queue
                genValidWordSeq(currWord, wordSet);

            }
            
            ans++;
            
        }
        
        return 0;
           
    }
    
    public void genValidWordSeq(String word, HashSet<String> wordSet){
        
        for(int i = 0; i<word.length(); i++){
            
            char[] ip = word.toCharArray();
            
            for(char c ='a'; c<= 'z' ; c++){
                
                ip[i] = c;
                
                String newWord = String.valueOf(ip);
                if(wordSet.contains(newWord)){
                    q.add(newWord);
                    wordSet.remove(newWord);
                }
            }
            

        }
        
    }
}