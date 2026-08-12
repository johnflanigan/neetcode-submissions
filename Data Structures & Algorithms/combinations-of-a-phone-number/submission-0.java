class Solution {

    private static final Map<Character, List<Character>> MAP = getLetters();

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }

        StringBuilder sb = new StringBuilder();

        dfs(digits, 0, combinations, sb);

        return combinations;    
    }

    private void dfs(String digits, int i, List<String> combinations, StringBuilder sb) {
        if (i == digits.length()) {
            combinations.add(sb.toString());
            return;
        }

        for (char c : MAP.get(digits.charAt(i))) {
            sb.append(c);
            dfs(digits, i + 1, combinations, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }



    private static Map<Character, List<Character>> getLetters() {
        Map<Character, List<Character>> map = new HashMap<>();

        List<Character> list2 = new ArrayList<>();
        list2.add('a');
        list2.add('b');
        list2.add('c');
        map.put('2', list2);

        List<Character> list3 = new ArrayList<>();
        list3.add('d');
        list3.add('e');
        list3.add('f');
        map.put('3', list3);
    
        List<Character> list4 = new ArrayList<>();
        list4.add('g');
        list4.add('h');
        list4.add('i');
        map.put('4', list4);
    
        List<Character> list5 = new ArrayList<>();
        list5.add('j');
        list5.add('k');
        list5.add('l');
        map.put('5', list5);

        List<Character> list6 = new ArrayList<>();
        list6.add('m');
        list6.add('n');
        list6.add('o');
        map.put('6', list6);
    
        List<Character> list7 = new ArrayList<>();
        list7.add('p');
        list7.add('q');
        list7.add('r');
        list7.add('s');
        map.put('7', list7);
    
        List<Character> list8 = new ArrayList<>();
        list8.add('t');
        list8.add('u');
        list8.add('v');
        map.put('8', list8);

        List<Character> list9 = new ArrayList<>();
        list9.add('w');
        list9.add('x');
        list9.add('y');
        list9.add('z');
        map.put('9', list9);

        return map;
    }
}
