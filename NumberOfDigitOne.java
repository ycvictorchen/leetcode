public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        if (n < 1) {
            return 0;
        }
        int result = 0;
        int remaining = 0;
        int factor = 1;
        while (n > 0) {
            remaining += (n % 10) * factor;
            result += (n / 10) * factor + Math.max(0, Math.min(remaining - (factor - 1), factor));
            n /= 10;
            if (n > 0) {
                factor *= 10;
            }
        }
        return result;
    }
}