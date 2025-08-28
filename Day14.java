import java.util.*;

public class CountKDistinctSubstrings {
    public static int countSubstringsWithKDistinct(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    private static int atMostKDistinct(String s, int k) {
        if (k == 0) return 0;
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        int result = countSubstringsWithKDistinct(s, k);
        System.out.println(result);
        sc.close();
    }
}
