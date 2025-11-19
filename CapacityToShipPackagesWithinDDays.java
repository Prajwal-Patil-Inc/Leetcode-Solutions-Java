public class CapacityToShipPackagesWithinDDays {
    // Brute
    // public static int shipWithinDays(int[] weights, int days) {
    //     int max = Integer.MIN_VALUE, maxSum = 0;
    //     maxSum = weights.length * ( weights.length + 1) / 2;
    //     for (int i : weights) {
    //         max = Math.max(max, i);
    //     }
    //     int res = -1;
    //     for (int i = max; i <= maxSum; i++) {
    //         int daysReq = canLoad(weights, i);
    //         System.out.println("Days Req: "+daysReq+"  for i: "+i);
    //         if(daysReq <= days){
    //             res = i;
    //             break;
    //         }
    //     }
    //     return res;
    // }

    public static int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE, right = 0;
        for (int i : weights) {
            right += i;
            left = Math.max(left, i);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int daysReq = canLoad(weights, mid);
            if(daysReq <= days){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static int canLoad(int[] weights, int cap){
        int days = 1, load = 0;
        for(int i=0; i<weights.length; i++){
            if(load + weights[i] > cap){
                days = days + 1;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }

    public static void main(String[] args) {
        // int[] weights = {1,2,3,4,5,6,7,8,9,10}; int days = 5;
        // int[] weights = {3,2,2,4,1,4}; int days = 3;
        // int[] weights = {1,2,3,1,1}; int days = 4;
        int[] weights = {10,50,100,100,50,100,100,100}; int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
