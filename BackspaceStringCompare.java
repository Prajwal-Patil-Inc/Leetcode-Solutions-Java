public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        String s1 = constructString(s);
        String t1 = constructString(t);  

        return s1.equals(t1);
    }

    public static String constructString(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '#'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       String s = "ab#c", t = "ad#c";
       System.out.println(backspaceCompare(s, t));
    }
}
