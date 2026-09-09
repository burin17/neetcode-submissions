class Solution {
    // ["act","pots","tops","cat","stop","hat"]
    // map<int[],list> = 
    // o(n * m) runtime
    // o(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] charMap = new int[26];
            for (char c : str.toCharArray()) {
                charMap[c - 'a']++;
            }
            var charMapStr = Arrays.toString(charMap);
            List<String> group = map.get(charMapStr);
            if (group == null) {
                group = new ArrayList<>();
                map.put(charMapStr, group);
            }
            group.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
