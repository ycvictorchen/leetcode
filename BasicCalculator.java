public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        java.util.Deque<String> deque = new java.util.ArrayDeque<String>();
        int l = s.length();
        int i = 0;
        while (i < l) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < l && (Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ')) {
                    if (Character.isDigit(s.charAt(i))) {
                        sb.append(s.charAt(i));
                    }
                    i++;
                }
                this.push(deque, sb.toString());
                continue;
            }
            if (c == '(') {
                deque.push("(");
            }
            else if (c == ')') {
                String t = deque.pop();
                deque.pop();
                this.push(deque, t);
            }
            else if (c == '+' || c == '-') {
                deque.push(s.substring(i, i + 1));
            }
            i++;
        }
        return deque.size() == 0 ? 0 : Integer.parseInt(deque.pop());
    }
    private void push(java.util.Deque<String> deque, String num) {
        if (deque.isEmpty() || deque.peek().equals("(")) {
            deque.push(num);
            return;
        }
        String top = deque.peek();
        if (top.equals("+") || top.equals("-")) {
            deque.pop();
            String t = deque.pop();
            this.push(deque, String.valueOf(top.equals("+") ?
                Integer.parseInt(t) + Integer.parseInt(num) :
                Integer.parseInt(t) - Integer.parseInt(num))
            );
        }
    }
}