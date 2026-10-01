class Solution {

    // time O(n) space = O(n + m)
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(strs.size() + ",");
        for (String s : strs) sb.append(s.length()).append(",");
        for (String s : strs) sb.append(s);
        return sb.toString();
    }

    // time O(n) space = O(n + m)
    public List<String> decode(String str) {
        String numStr = String.valueOf(str.charAt(0)); // 2
        int i = 1;
        while (str.charAt(i) != ',') numStr += str.charAt(i++);
        int lengthsStartAt = ++i; // 2
        int num = Integer.parseInt(numStr); // 2
        List<String> res = new ArrayList<>();
        if (num == 0) return res;
        int numberOfCommas = 0;
        while (numberOfCommas < num) {
            if (str.charAt(i) == ',') numberOfCommas++;
            i++;
        }
        String[] lengths = str.substring(lengthsStartAt, i - 1).split(","); // [5, 5]
        String payload = str.substring(i); // [7]
        int startAt = 0;
        for (int j = 0; j < num; ++j) {
            int length = Integer.valueOf(lengths[j]);
            res.add(payload.substring(startAt, startAt + length));
            startAt += length;
        }
        return res;
    }
}
