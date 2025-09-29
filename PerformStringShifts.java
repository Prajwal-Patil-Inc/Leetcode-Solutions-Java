public class PerformStringShifts {
    public static String stringShift(String s, int[][] shift) {
        String res = s;
        for(int[] sft : shift){
            int dir = sft[0];
            int pos = sft[1];
            pos = pos % s.length();
            if(dir == 1){
                res = res.substring(s.length() - pos) + res.substring(0, s.length() - pos);
            }else{
                res = res.substring(pos) + res.substring(0, pos);   
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abc";
        int[][] shift = {{0,1},{1,2}};

        // String s = "abcdefg";
        // int[][] shift ={{1,1},{1,1},{0,2},{1,3}};
        System.out.println(stringShift(s, shift));
    }
}
