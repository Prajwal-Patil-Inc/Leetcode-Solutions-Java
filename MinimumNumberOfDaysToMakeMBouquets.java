public class MinimumNumberOfDaysToMakeMBouquets {
    
    // public static int minDays(int[] bloomDay, int m, int k) {
    // int res = Integer.MAX_VALUE;
    // for(int i : bloomDay){
    // if(possible(bloomDay, i, m, k)){
    // res = Math.min(i, res);
    // }
    // }
    // return res;
    // }

    public static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length)
            return -1; // cast to long to be safe
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int left = min, right = max, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0, noOfB = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                noOfB += count / k;
                count = 0;
            }
        }
        noOfB += count / k;
        return noOfB >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 7, 7, 7, 7, 12, 7, 7 };
        int m = 2, k = 3;
        System.out.println(minDays(bloomDay, m, k));
    }
}
