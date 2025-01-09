import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int solution(String S, int[] X, int[] Y) {
        int n = S.length();
        Map<Character, Integer> minDistance = new HashMap<>();

        // Iterate over all points to compute distances and track minimum distance for each tag
        for (int i = 0; i < n; i++) {
            char tag = S.charAt(i);
            int distanceSquared = X[i] * X[i] + Y[i] * Y[i];

            // Update the minimum distance for the tag
            minDistance.put(tag, Math.min(minDistance.getOrDefault(tag, Integer.MAX_VALUE), distanceSquared));
        }

        // Collect all unique distances
        List<Integer> distances = new ArrayList<>(minDistance.values());

        // Sort distances to include as many points as possible within the circle
        Collections.sort(distances);

        return distances.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String S1 = "ABDCA";
        int[] X1 = {2, -1, -4, -3, 3};
        int[] Y1 = {2, -2, 4, 1, -3};
        System.out.println(solution.solution(S1, X1, Y1)); // Output: 3

        // Example 2
        String S2 = "ABB";
        int[] X2 = {1, -2, -2};
        int[] Y2 = {1, -2, 2};
        System.out.println(solution.solution(S2, X2, Y2)); // Output: 1

        // Example 3
        String S3 = "CCD";
        int[] X3 = {1, -1, 2};
        int[] Y3 = {1, -1, -2};
        System.out.println(solution.solution(S3, X3, Y3)); // Output: 0
    }
}
