import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if(s.length() < p.length()) return res;
        
        //Hashmap for p string
        HashMap<Character, Integer> pmap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pmap.put(ch, pmap.getOrDefault(ch, 0)+1);
        }

        HashMap<Character, Integer> smap = new HashMap<>();
        int left = 0, right = 0;
        int windowLen = p.length();

        while(right < s.length()){
            char ch = s.charAt(right);
            //If the p hashmap contains the current char, put the char in the s hashmap
            if(pmap.containsKey(ch)){
                smap.put(ch, smap.getOrDefault(ch, 0)+1);
            }

            //If the window length is hit
            if(right - left + 1 == windowLen){
                //Check if the anagram matches
                if(smap.equals(pmap)){
                    res.add(left);
                }

                //Shrink
                char leftChar = s.charAt(left);
                //Reduce and Delete the char at left from smap
                if(pmap.containsKey(leftChar)){
                    smap.put(leftChar, smap.get(leftChar)-1);
                    if(smap.get(leftChar)==0){
                        smap.remove(leftChar);
                    }
                }
                //Move
                left++;
            }
            //Expand window
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
