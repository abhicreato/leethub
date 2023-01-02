class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int s = 0;
        int e = letters.length-1;
        int mid = 0;
        char result = ' ';
        
        while(s<=e){
            
            mid = (s+e)/2;
            
            if(letters[mid]==target){
                s = mid + 1;
            }else if(target>letters[mid]){
                s = mid + 1;
            }else if(target<letters[mid]){
                result = letters[mid];
                e = mid - 1;
            }
        }
        
        
        //corner cases
        if(result == ' ' && mid == letters.length-1){
            return letters[0];
        }
        
        return result;
    }
}