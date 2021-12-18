// Given a sorted array A[] of size N, delete all the duplicates elements from A[].
// Note: Don't use set or HashMap to solve the problem.

package Arrays;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();
            
            Solution g = new Solution();
            int n = g.remove_duplicate(a,N);
            
            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int remove_duplicate(int a[],int N){
        int new_length=0;
		for(int i=0;i<N-1;i++)
		{
		    if(a[i] != a[i+1])
		    {
		        a[new_length++] = a[i];
		    }
		}
		a[new_length++] = a[N-1];
		return new_length;
    }
}