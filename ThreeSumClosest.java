public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return 0;
        }
        java.util.Arrays.sort(num);
        int result = num[0] + num[1] + num[2];
        if (result == target) {
            return result;
        }
        int l = num.length;
        for (int i = 0; i < l - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = l - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == target) {
                    return target;
                }
                else {
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                    if (sum < target) {
                        while (j < l - 1 && num[j] == num[++j]);
                    }
                    else {
                        while (k > i + 1 && num[k] == num[--k]);
                    }
                }
            }
        }
        return result;
    }
}