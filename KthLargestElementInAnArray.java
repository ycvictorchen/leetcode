public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return this.findKthLargest(nums, k, 0, nums.length - 1);
    }
    private int findKthLargest(int[] nums, int k, int i, int j) {
        if (i >= j) {
            return nums[i];
        }
        int p = i;
        int q = i;
        int m = (i + j) / 2;
        this.swap(nums, m, j);
        for (; p < j; p++) {
            if (nums[p] > nums[j]) {
                this.swap(nums, p, q);
                q++;
            }
        }
        this.swap(nums, q, j);
        if (k == q + 1) {
            return nums[q];
        }
        if (k > q + 1) {
            return this.findKthLargest(nums, k, q + 1, j);
        }
        return this.findKthLargest(nums, k, i, q - 1);
    }
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}