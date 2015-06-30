public class MajorityElement2 {
    public java.util.List<Integer> majorityElement(int[] nums) {
        java.util.List<Integer> result = new java.util.ArrayList<Integer>();
        if (nums != null && nums.length > 0) {
            int ln = nums.length,
                n1 = 0,
                n2 = 0,
                c1 = 0,
                c2 = 0;
            for (int i = 0; i < ln; i++) {
                int n = nums[i];
                if (c1 > 0 && c2 > 0) {
                    if (n == n1) {
                        c1++;
                    }
                    else if (n == n2) {
                        c2++;
                    }
                    else {
                        c1--;
                        c2--;
                    }
                }
                else if (c1 > 0) {
                    if (n == n1) {
                        c1++;
                    }
                    else {
                        n2 = n;
                        c2++;
                    }
                }
                else if (c2 > 0) {
                    if (n == n2) {
                        c2++;
                    }
                    else {
                        n1 = n;
                        c1++;
                    }
                }
                else {
                    n1 = n;
                    c1++;
                }
            }
            c1 = 0;
            c2 = 0;
            for (int i = 0; i < ln; i++) {
                if (nums[i] == n1) {
                    c1++;
                }
                else if (nums[i] == n2) {
                    c2++;
                }
            }
            int threshold = ln / 3;
            if (c1 > threshold) {
                result.add(n1);
            }
            if (n2 != n1 && c2 > threshold) {
                result.add(n2);
            }
        }
        return result;
    }
}