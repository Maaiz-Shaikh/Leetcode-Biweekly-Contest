class Solution {
    
    /*
    
    Tip: When ever we are moving from left to right always think of prefix sum
    
    Calculate everything and then make changes
    Steps:
    1)Create an offset
    2)Do prefix sum
    3)Make changes to individual letter and add to result
    */
    public String shiftingLetters(String s, int[][] shifts) {
        
        int[] offset = new int[s.length()+1];
        for(int i=0; i<shifts.length; i++){
            int start = shifts[i][0];
            int end = shifts[i][1];
            int dir = shifts[i][2];
            offset[start]+=(dir==1)? 1:-1;
            offset[end+1]-=(dir==1)? 1:-1;
        }
        
        int prefix = 0;
        String result = "";
        for(int j=0; j<s.length(); j++){
            prefix+=offset[j];
            while(prefix<0) prefix+=26;  //for wrap around
            int ch = (s.charAt(j) - 'a' + prefix)%26;  // to be in range
            result+=(char)('a' + ch);
        }
      
        return result;
    }
}
