public class OCRStringComparison {

    public static boolean solution(String S, String T) {
        return match(S, T, 0, 0);
    }

    private static boolean match(String S, String T, int i, int j) {
        int n = S.length();
        int m = T.length();

        // Traverse through both strings
        while (i < n && j < m) {
            char c1 = S.charAt(i);
            char c2 = T.charAt(j);

            if (Character.isDigit(c1)) {
                // Expand number in S
                int num1 = 0;
                while (i < n && Character.isDigit(S.charAt(i))) {
                    num1 = num1 * 10 + (S.charAt(i++) - '0');
                }
                j += num1;
            } else if (Character.isDigit(c2)) {
                // Expand number in T
                int num2 = 0;
                while (j < m && Character.isDigit(T.charAt(j))) {
                    num2 = num2 * 10 + (T.charAt(j++) - '0');
                }
                i += num2;
            } else {
                // Compare characters
                if (c1 != c2) {
                    return true;
                }
                i++;
                j++;
            }
        }

        // Check if we have exhausted both strings
        while (i < n && Character.isDigit(S.charAt(i))) {
            i++;
        }
        while (j < m && Character.isDigit(T.charAt(j))) {
            j++;
        }

        return i == n && j == m;
    }

    public static void main(String[] args) {
        String S = "A2Le";
        String T = "2pL1";

        boolean result = solution(S, T);
        System.out.println("Do the strings match? " + result);
    }
}
