//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        List<Character> stack = new ArrayList<>();
        int n = x.length();
        for(int i=0;i<n;i++) {
            char temp = x.charAt(i);
            if(temp == '{' || temp == '[' || temp == '(') {
                stack.add(temp);
            }
            if(stack.isEmpty())
                return false;
            char tos;
            switch(temp) {
                case '}' :  tos = stack.remove(stack.size()-1);
                            if(tos == '[' || tos == '(')
                                return false;
                            break;
                case ']' :  tos = stack.remove(stack.size()-1);
                            if(tos == '(' || tos == '{')
                                return false;
                            break;
                case ')' :  tos = stack.remove(stack.size()-1);
                            if(tos == '{' || tos == '[')
                                return false;
                            break;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
