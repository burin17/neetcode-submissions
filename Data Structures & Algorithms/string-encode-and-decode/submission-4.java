class Solution {

    // ["Hello","World"]
    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        sb.append(strs.size()).append('#');
        for (String str : strs) sb.append(str.length()).append('#');
        sb.deleteCharAt(sb.length() - 1);
        sb.append('|');
        for (String str : strs) sb.append(str);
        return sb.toString();
    }

    // "2#5#5|HelloWorld"
    public List<String> decode(String str) {
        int metadataEndAt = str.indexOf('|');
        String metadataStr = str.substring(0, metadataEndAt);
        String[] metadata = metadataStr.split("#");
        List<String> res = new ArrayList<>();
        int numOfStrs = Integer.valueOf(metadata[0]);
        if (numOfStrs == 0) return res;
        String payload = str.substring(metadataEndAt + 1);
        int startAt = 0;
        for (int i = 1; i <= numOfStrs; ++i) {
            int length = Integer.valueOf(metadata[i]);
            res.add(payload.substring(startAt, startAt + length));
            startAt+=length;
        }
        return res;
    }
}
