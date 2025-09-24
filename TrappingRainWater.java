public class TrappingRainWater{
    public int findTRW(int height[]){
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = height[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }

        int waterCount = 0;
        for(int i=0; i<n; i++){
            waterCount += (Math.min(left[i], right[i]) - height[i]);
        }
        return waterCount;
    }
    public static void main(String[] args) {
        TrappingRainWater trp = new TrappingRainWater();
        int height[] = {4,2,0,3,2,5};
        System.out.println("Trapped rain water: "+ trp.findTRW(height));
    }
}