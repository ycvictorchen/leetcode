public class SummaryRanges {
    public java.util.List<String> summaryRanges(int[] nums) {
        java.util.List<String> result = new java.util.ArrayList<String>();
        if (nums != null && nums.length > 0) {
            for (int i = 1, j = 0, l = nums.length; i <= l; i++) {
                if (i == l || nums[i - 1] + 1 < nums[i]) {
                    result.add(i - j == 1 ? nums[j] + "" : nums[j] + "->" + nums[i - 1]);
                    j = i;
                }
            }
        }
        return result;
    }
}