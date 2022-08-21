class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int n = s.length();
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        for(int i=0; i<n/2; i++){
            char temp = arr1[i];
            arr1[i] = arr1[n-i-1];
            arr1[n-i-1] = temp;
        }
      
        char[] arr2 = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            arr2[i] = s.charAt(i);
        }
        
        int count = 0;
        while(!Arrays.equals(arr1,arr2)){
            for(int j=0; j<s.length(); j++){
                if(j+1!=s.length() && arr2[j] == '0' && arr2[j+1] == '1'){
                    arr2[j] = '1';
                    arr2[j+1] = '0';
                    j++;
                }
            }
            count++;
        }
        
        return count;
    }
}
