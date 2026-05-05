import java.util.*;

class question2 {
    public static int minOperations(int[] A, int K) {
        int n = A.length;

        // Step 1: Check feasibility
        int mod = A[0] % K;
        for (int i = 1; i < n; i++) {
            if (A[i] % K != mod) {
                return -1;
            }
        }

        // Step 2: Normalize
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = A[i] / K;
        }

        // Step 3: Sort
        Arrays.sort(B);

        // Step 4: Median
        int median = B[n / 2];

        // Step 5: Count operations
        int operations = 0;
        for (int i = 0; i < n; i++) {
            operations += Math.abs(B[i] - median);
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 6, 8, 10};
        int K = 2;
        System.out.println(minOperations(A, K)); // Output: 6
    }
}