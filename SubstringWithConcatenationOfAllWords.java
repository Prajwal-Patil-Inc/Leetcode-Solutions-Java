import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        HashMap<String, Integer> wordsMap = new HashMap<>();
        
        int wordLength = words[0].length();
        int windowLength = wordLength * words.length;

        for (String w : words) {
            wordsMap.put(w, wordsMap.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;

            HashMap<String, Integer> seen = new HashMap<>();

            while (right + wordLength <= s.length()) {

                //Right substring -> ex: bar 
                String sub = s.substring(right, right + wordLength);

                //If valid string
                if (wordsMap.containsKey(sub)) {
                    
                    //Put in seen
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);

                    //If the frequency count of the right substring gets more than in the wordsmap
                    if (seen.get(sub) > wordsMap.get(sub)) {
                        
                        //Get left substring
                        String leftSub = s.substring(left, left + wordLength);

                        //Shrink till we get equal number of frequencies
                        while (seen.get(leftSub) > wordsMap.get(leftSub)) {
                            seen.put(leftSub, seen.get(leftSub) - 1);
                            left += wordLength;
                            leftSub = s.substring(left, left + wordLength); //Get next substring
                        }
                    }
                }
                //If not a valid substring 
                else {
                    seen.clear();
                    left = right + wordLength; //Move left -> shrink by twice 
                }

                //If window is hit
                if (right + wordLength - left == windowLength) {
                    if (seen.equals(wordsMap)) {
                        res.add(left);
                    }
                }

                //Move right
                right += wordLength;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // String s = "barfoothefoobarman";
        // String[] words = { "foo", "bar" };
        String s = "barfoofoobarthefoobarman"; String[] words = {"bar","foo","the"};
        System.out.println(findSubstring(s, words));
    }
}
