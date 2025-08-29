import java.util.HashSet;

public class LongestUniqueSubstring {
    public static int longestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring("bbbbb"));
        System.out.println(longestSubstring("pwwkew"));
        System.out.println(longestSubstring("abcdefgh"));
        System.out.println(longestSubstring("a"));
    }
}
