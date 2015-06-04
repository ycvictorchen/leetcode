public class HappyNumber {
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        int slow = n;
        int fast = n;
        while (true) {
            slow = this.next(slow);
            fast = this.next(this.next(fast));
            if (slow == 1 || fast == 1) {
                return true;
            }
            if (slow == fast) {
                break;
            }
        }
        return false;
    }
    private int next(int n) {
        int next = 0;
        while (n > 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return next;
    }
}