public class LetterCombinationsOfAPhoneNumber {
    public java.util.List<String> letterCombinations(String digits) {
        java.util.List<String> result = new java.util.ArrayList<String>();
        if (digits != null && digits.length() > 0) {
            char[][] chars= {
                {' '},
                {' '},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
            };
            this.build(result, chars, digits, 0, "");
        }
        return result;
    }
    private void build(java.util.List<String> result, char[][] chars, String digits, int i, String s) {
        if (s.length() == digits.length()) {
            result.add(s);
            return;
        }
        int digit = digits.charAt(i) - '0';
        for (int j = 0; j < chars[digit].length; j++) {
            this.build(result, chars, digits, i + 1, s + chars[digit][j]);
        }
    }
}