import java.util.*;

class question1 {
    public static int maxCyclicSubstringSum(String s) {
        int n = s.length();
        String s2 = s + s;

        Set<Character> set = new HashSet<>();
        int left = 0, sum = 0, maxSum = 0;

        for (int right = 0; right < s2.length(); right++) {
            char ch = s2.charAt(right);

            // Remove until unique & valid length
            while (set.contains(ch) || (right - left + 1) > n) {
                char leftChar = s2.charAt(left);
                set.remove(leftChar);
                sum -= (leftChar - 'a' + 1);
                left++;
            }

            // Add current character
            set.add(ch);
            sum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(maxCyclicSubstringSum(s)); 
    }
}