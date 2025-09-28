public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String s){
        if(s == null || s.length() < 1) return ""; //Base condition check
        int start = 0, end = 0; //Two pointers for substring
        for(int i=0; i<s.length(); i++){ 
            int len1 = expandFromMiddle(s, i, i); //For odd palindromic strings
            int len2 = expandFromMiddle(s, i, i+1); //For even palindromic strings
            int len = Math.max(len1, len2); 
            if(len > end - start){ //If the current len of palin substr is greater than the last
                start = i - ((len - 1) / 2); //Readjust the pointers - i is the current center of the palin substr 
                end = i + (len / 2); //Works for even and odd both
            }
        }
        return s.substring(start, end+1);
    }

    public static int expandFromMiddle(String s, int left, int right){
        if(s == null || left > right)   return 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){ //bounds checks and equality check
            left--;
            right++; //expand
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        String s1 = "racecar";
        System.out.println(longestPalindromicSubstring(s));
    }
}
