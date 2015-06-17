public class JumpGame2 {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int reached = 0,
            jumps = 0,
            i = 0,
            l = nums.length;
        while (i < l) {
            int t = reached;
            for (; i < Math.min(l, t + 1); i++) {
                reached = Math.max(reached, i + nums[i]);
                if (reached >= l - 1) {
                    return jumps + 1;
                }
            }
            jumps++;
        }
        return 0;
    }
}