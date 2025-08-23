public class CommonPrefixSolver {

    public static String findLongestPrefix(String[] words) {
        if (words == null || words.length == 0) return "";

        // Assume the first word as the base prefix
        String candidate = words[0];

        // Compare with each word in the list
        for (int i = 1; i < words.length; i++) {
            // Trim the candidate until it matches the beginning of the word
            while (!words[i].startsWith(candidate)) {
                candidate = candidate.substring(0, candidate.length() - 1);
                if (candidate.isEmpty()) return "";
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        // Test Cases
        String[] arr1 = {"flower", "flow", "flight"};
        System.out.println(findLongestPrefix(arr1)); // "fl"

        String[] arr2 = {"dog", "racecar", "car"};
        System.out.println(findLongestPrefix(arr2)); // ""

        String[] arr3 = {"apple", "ape", "april"};
        System.out.println(findLongestPrefix(arr3)); // "ap"

        String[] arr4 = {""};
        System.out.println(findLongestPrefix(arr4)); // ""

        String[] arr5 = {"alone"};
        System.out.println(findLongestPrefix(arr5)); // "alone"

        String[] arr6 = {}; // Edge case: empty array
        System.out.println(findLongestPrefix(arr6)); // ""
    }
}
