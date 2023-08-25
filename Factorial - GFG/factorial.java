//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.factorial(N));
        }
    }
}
// } Driver Code Ends


class Solution{
    static long helper(int n, long[] dp) {
        if(n == 0)
            return 1;
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = n * helper(n-1, dp);
    }
    static long factorial(int n){
        // code here
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
}