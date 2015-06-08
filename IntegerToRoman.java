public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] majors = {'I','X','C','M'};
        char[] minors = {'V','L','D'};
        int multiple = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 9) {
                sb.insert(0, majors[multiple + 1]);
                sb.insert(0, majors[multiple]);
            }
            else if (digit >= 5) {
                for (int i = 5; i < digit; i++) {
                    sb.insert(0, majors[multiple]);
                }
                sb.insert(0, minors[multiple]);
            }
            else if (digit == 4) {
                sb.insert(0, minors[multiple]);
                sb.insert(0, majors[multiple]);
            }
            else {
                for (int i = 0; i < digit; i++) {
                    sb.insert(0, majors[multiple]);
                }
            }
            multiple++;
            num /= 10;
        }
        return sb.toString();
    }
}