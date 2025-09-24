// Question: You’re given a list of score records, where each record is a pair: [student_id, score]. A student can have multiple score entries.

// Your job is to compute, for each student, the average of their top five scores (using integer division, i.e. discard any remainder). Then return a list of pairs [student_id, topFiveAverage], sorted by the student_id in ascending order. It is guaranteed that each student has at least five scores.

// Input:

// items = [
//   [1, 91], [1, 92], [2, 93], [2, 97], [1, 60],
//   [2, 77], [1, 65], [1, 87], [1, 100], [2, 100], [2, 76]
// ]


// Output:

// [[1, 87], [2, 88]]

//First make the treemap to map id and score(in a priority queue)
//iterate over the given items in a foreach(int[] item: items)
//IN it, store the id and scores in the int vars
//Check if the given id already exists in the treemap
//If it does, then make a new PQ, get the treemap.get(id)
//offer the new score to it
//also check if the current PQ size > 5, if yes, poll
//else treemap.put(id, PQ)

//Next, create a results array[][]
//foreach(int id: treemap.keySet) //Getting each if from the treemap
//sum = 0
//PQ = treemap.get(id);
//while(!treemap.isEmpty())
//sum += PQ.poll()
//result[id - 1][0] = id
//result[id - 1][1] = scores
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HighFive {

    public static int[][] highFive(int[][] items){
        TreeMap<Integer, PriorityQueue<Integer>> tmap = new TreeMap<>();
        for(int[] item : items){
            int id = item[0];
            int score = item[1];

            if(tmap.containsKey(id)){
                PriorityQueue<Integer> heap = tmap.get(id);
                heap.offer(score);
                if(heap.size() > 5){
                    heap.poll();
                }
            }
            else{
                PriorityQueue<Integer> heap = new PriorityQueue<>();
                heap.offer(score);
                tmap.put(id, heap);
            }
        }

        int res[][] = new int[tmap.size()][2];
        int i = 0;
        for(int id : tmap.keySet()){
            int sum = 0;
            PriorityQueue<Integer> heap = tmap.get(id);
            while(!heap.isEmpty()){
                sum += heap.poll();
            }
            res[i][0] = id;
            res[i][1] = sum / 5;  //Calc average for 5 top scores
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int result[][] = highFive(items);
        for (int[] student : result) {
            System.out.println("Student ID: " + student[0] + ", Average Score: " + student[1]);
        }
    }

}
