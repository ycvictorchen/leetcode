public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int l = digits.length;
        int carryOver = 1;
        for (int i = l - 1; i >= 0; i--) {
            digits[i] += carryOver;
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[l + 1];
        result[0] = 1;
        return result;
    }
}