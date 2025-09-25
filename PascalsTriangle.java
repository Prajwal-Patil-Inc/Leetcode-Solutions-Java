import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for(int i=0; i<numRows; i++){
            curr.add(0,1);

            for(int j=1; j<curr.size()-1; j++){ //From first to last second index
                curr.set(j, curr.get(j) + curr.get(j+1));
            }
            output.add(new ArrayList<>(curr));
        }
        return output;
    }
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
