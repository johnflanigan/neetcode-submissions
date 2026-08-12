class Solution {

    public String encode(List<String> strs) {
        String result = "";

        for (int i = 0; i < strs.size(); i++) {
            result += strs.get(i);
            result += ".";
        }

        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        String word = "";
        for (char c : str.toCharArray()) {
            if (c == '.') {
                result.add(word);
                word = "";
            } else {
                word += c;
            }
        }

        return result;
    }
}
