public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][] = new int[rows][cols];

        //Bottom up
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if(i == rows - 1 && j == cols - 1){
                    dp[i][j] = grid[i][j];
                }
                else if(i == rows - 1){ // rows
                    dp[i][j] = dp[i][j+1] + grid[i][j]; 
                }
                else if(j == cols - 1){ //cols
                    dp[i][j] = dp[i+1][j] + grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}


/* We are allowed to move only down or right from the top.
Solution -> Build the dp from bottom up
Start at the bottom right cell.
Keep the value of the bottom right cell in the dp as it is = original value
Then for rows => i == rows - 1 -> store the right cell value of the dp + original grid => dp[i][j+1] + grid[i][j]
For cols => j == cols - 1 -> store the top bottom cell value of the dp + original grid => dp[i+1][j] + grid[i][j]
For others => get the min of either down or right cell + original grid => Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j] 
return the top cell as answer
 */