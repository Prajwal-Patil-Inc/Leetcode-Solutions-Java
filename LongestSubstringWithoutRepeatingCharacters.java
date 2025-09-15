public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int currLen = 0;
        int n = s.length();
        boolean[] set = new boolean[256]; //for all characters, numbers, symbols and spaces
        int i = 0; 
        int j = -1;
        while (i < n) {
            char ch_to_acquire = s.charAt(i);
            while(set[ch_to_acquire] == true){
               //Release 
               j++;
               char ch_to_release = s.charAt(j);
               set[ch_to_release] = false;  
            }
            set[ch_to_acquire] = true;
            currLen = i - j;
            maxLen = Math.max(maxLen, currLen);
            i++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
