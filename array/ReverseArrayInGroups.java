// Given an array arr[] of positive integers of size N. Reverse every sub-array group of size K.

package array;

// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReverseArrayInGroups {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        // while testcases exist
        while (t-- > 0) {

            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int k = Integer.parseInt(inputLine1[1]);

            ArrayList<Integer> arr = new ArrayList<>();
            String inputLine2[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(inputLine2[i]));
            }

            SolutionReverseArrayInGroups obj = new SolutionReverseArrayInGroups();
            obj.reverseInGroups(arr, n, k);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class SolutionReverseArrayInGroups {
    // Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            while (left < right) {
                int t = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, t);
                left++;
                right--;
            }
        }
    }
}
