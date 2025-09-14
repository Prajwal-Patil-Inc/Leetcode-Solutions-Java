/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. */
/*
Input: prices = [7,1,5,3,6,4]
Output: 5 
*/


public class BestTimeToBuyAndSellStocks {

    public int calculateBTTBSS(int[] prices){
        int min_val = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < min_val){
                min_val = prices[i];
            }
            else if(prices[i] - min_val > max_profit){
                max_profit = prices[i] - min_val;
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStocks b = new BestTimeToBuyAndSellStocks();
        System.out.println(b.calculateBTTBSS(prices));
    }

}
