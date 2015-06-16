public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int reached = 0;
        for (int i = 0, l = nums.length; i < Math.min(l, reached + 1); i++) {
            reached = Math.max(reached, i + nums[i]);
            if (reached >= l - 1) {
                return true;
            }
        }
        return false;
    }
}