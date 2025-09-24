import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        for(int[] interval : intervals){
            if(res.isEmpty() || res.get(res.size()-1)[1] < interval[0]){
                res.add(interval);
            }else{
                res.get(res.size()-1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for (int[] is : res) {
            System.out.print(is[0]+ " "+is[1]);
        }
    }
}
