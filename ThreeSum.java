public class ThreeSum {
    public java.util.List<java.util.List<Integer>> threeSum(int[] num) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<java.util.List<Integer>>();
        if (num != null && num.length > 2) {
            java.util.Arrays.sort(num);
            int l = num.length;
            for (int i = 0; i < l - 2 && num[i] <= 0; i++) {
                if (i > 0 && num[i] == num[i - 1]) {
                    continue;
                }
                int j = i + 1;
                int k = l - 1;
                while (j < k && num[j] <= -num[i]) {
                    int sum = num[i] + num[j] + num[k];
                    if (sum == 0) {
                        java.util.List<Integer> list = new java.util.ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        result.add(list);
                        while (j < l - 1 && num[j] == num[++j]);
                        while (k > i + 1 && num[k] == num[--k]);
                    }
                    else if (sum < 0) {
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