class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sChars = new int[26];
        int[] tChars = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            sChars[sChar - 'a']++;
            char tChar = t.charAt(i);
            tChars[tChar - 'a']++;
        }

        return Arrays.equals(sChars, tChars);
    }
}
