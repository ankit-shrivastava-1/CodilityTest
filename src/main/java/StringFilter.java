import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringFilter {
    public static String filterStrings(String dictionary, String message) {
        // Split the words of dictionary into a Set for faster lookups
        Set<String> wordsSet = new HashSet<>(Arrays.asList(dictionary.split(" ")));

        // Split the words of message and process them
        StringBuilder result = new StringBuilder();
        for (String word : message.split(" ")) {
            if (wordsSet.contains(word.toLowerCase())) {
                result.append(word).append(" ");
            } else {
                result.append("### ");
            }
        }

        // Return the resulting string
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String dictionary = "The Codility Coders Test";
        String message = "Codility tests the codes of coders";

        String result = filterStrings(dictionary.toLowerCase(), message.toLowerCase());
        System.out.println(result);
    }
}
