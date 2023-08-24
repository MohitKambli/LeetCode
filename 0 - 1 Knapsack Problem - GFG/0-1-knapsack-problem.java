//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    static int helper(int W, int wt[], int val[], int n, int index, int[][] dp) {
        if(index == n-1) {
            if(wt[index] <= W)
                return val[index];
            else 
                return 0;
        }
        if(dp[W][index] != -1)
            return dp[W][index];
            
        int pick = Integer.MIN_VALUE;
        if(wt[index] <= W)
            pick = val[index] + helper(W-wt[index], wt, val, n, index + 1, dp);
        int notPick = 0 + helper(W, wt, val, n, index + 1, dp);
        
        return dp[W][index] = Math.max(pick, notPick);
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[W+1][n];
         for(int[] row : dp)
            Arrays.fill(row, -1);
         return helper(W, wt, val, n, 0, dp);
    } 
}


