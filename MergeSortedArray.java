public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return;
        }
        int i = m - 1,
            j = n - 1,
            k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0 && nums1[i] >= nums2[j] || j < 0) {
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}