import java.util.Arrays;

public class ValidAnagrams {
    public static boolean isAnagram(String s, String t) {
        // if(s.length() != t.length())    return false;
        // int char_counts[] = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     char_counts[s.charAt(i) - 'a']++;
        //     char_counts[t.charAt(i) - 'a']--;
        // }
        // for (int i : char_counts) {
        //     if(i != 0){
        //         return false;
        //     }
        // }
        // return true;
        if(s.length() != t.length())    return false;
        int s_char_counts[] = new int[26];
        int t_char_counts[] = new int[26];
        for(char c : s.toCharArray()){
            s_char_counts[c-'a']++;
        }
        for (char b : t.toCharArray()) {
            t_char_counts[b - 'a']++;
        }
        return Arrays.equals(s_char_counts, t_char_counts);
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}

//here we go through each character and increment its count in the char_counts array.
// we use 's.charAt('currentChar') - 'a' which will return the index of the current char.
//increment if found in the source and decrement if found in the target
//if the char_counts array is evened out then matched, else false

//OR

//Make two arrays for s and t character counts
//for every char in s and t, store the count of that letter in the array
//compare the arrays for equality, if equal true, else false