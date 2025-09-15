import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int valid = 0, start = 0;
        
        //Populating the need hashmap for the character frequency count
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        //Sliding window start
        while (right < s.length()) {
            char ch = s.charAt(right);
            
            //Putting the characters and their frequencies in the hashmap
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            //If the current character is found in the need and windows hashmap then increment the valid counter, but only if it exists in the needs hashmap
            if (need.containsKey(ch) && window.get(ch).equals(need.get(ch))) {
                valid++;
            }

            //Shrinking the window from left If the valid counter has reached the needs hashmap size, meaning that all the characters have been found in the String s.
            while (valid == need.size()) {

                //Checking for the min length window size
                if (right - left + 1 < minLen) {
                    start = left; //Updating the start to extract the substring from S
                    minLen = right - left + 1;
                }
                
                //Starting to shrink
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1); //Decrementing the left char count from the window hashmap

                //If the char count in the window and the need hashmap doesn't match, then decrement the valid to exit the loop.
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    valid--;
                }

                //Shrink
                left++;
            }
            //Expand
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        // String s = "ADOBECODEBANC", t = "ABC";
        // String s = "a", t = "a";
        String s ="cabwefgewcwaefgcf", t ="cae";
        System.out.println(minWindow(s, t));

    }
}


/*
  We need two hashmaps for s and t, respectively.
  Store the freq count of T in the needs.
  Start the while loop for sliding window to calc the minLen.
  Add the freq count of the right pointer chars in the window hashmap.

  If the current char in the window exists in the needs hm, and basically agar wo dono ki frequency same hai in both hmaps then valid ko increment karo kyuki hame ek aur valid char in the string s mil gaya hai jo string t me hai.

  ek aur inner while loop chalao for shrinking the window -> valid == need.size()
    1. abhi pahle minlen calculate karna hai -> if(right - left + 1 < minLen) -> start = left; minLen = right - left + 1;
    2. Now decrement the char count on the left from the window hm.
    3. Now check if the char exists in the t hm and along with it, check if that character frequency is less than in the window hm compared to needs hm. -> Then decrement valid as we lost one character on the left.
    4. Shrink from left -> left++;

  ab expand karo -> right++;

  return 
*/