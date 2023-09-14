//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int helper(int i, int j, int N, int[][] m, int[][] dp) {
        if(j < 0 || j > N-1)
            return Integer.MIN_VALUE;
        if(i == 0)
            return m[i][j];    
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int upperLeft = m[i][j] + helper(i-1, j-1, N, m, dp);
        int up = m[i][j] + helper(i-1, j, N, m, dp);
        int upperRight = m[i][j] + helper(i-1, j+1, N, m, dp);
        return dp[i][j] = Math.max(upperLeft, Math.max(up, upperRight));
    }
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int[][] dp = new int[N][N];
        for(int[] x : dp)
            Arrays.fill(x, -1);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            ans = Math.max(ans, helper(N-1, i, N, Matrix, dp));
        }
        return ans;
    }
}