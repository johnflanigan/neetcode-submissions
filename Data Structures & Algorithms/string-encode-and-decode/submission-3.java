class Solution {

    public String encode(List<String> strs) {
        String result = "";

        for (int i = 0; i < strs.size(); i++) {
            // System.out.println(strs.get(i));
            result += strs.get(i);
            result += ".";
        }
        // System.out.println(result);
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
