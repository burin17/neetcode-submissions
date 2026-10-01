class Solution {

    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for (var str : strs) sb.append(str.length()).append('#').append(str);
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < str.length()) {
            var lengthOfStrSb = new StringBuilder();
            while (str.charAt(i) != '#') lengthOfStrSb.append(str.charAt(i++));
            i++;
            int lengthOfStr = Integer.valueOf(lengthOfStrSb.toString());
            res.add(str.substring(i, i + lengthOfStr));
            i += lengthOfStr;
        }
        return res;
    }
}
