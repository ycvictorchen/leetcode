public class FourSum {
    public java.util.List<java.util.List<Integer>> fourSum(int[] num, int target) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<java.util.List<Integer>>();
        if (num != null && num.length > 3) {
            java.util.Arrays.sort(num);
            int l = num.length;
            for (int i = 0; i < l - 3; i++) {
                if (i > 0 && num[i] == num[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < l - 2; j++) {
                    if (j > i + 1 && num[j] == num[j - 1]) {
                        continue;
                    }
                    int m = j + 1;
                    int n = l - 1;
                    while (m < n) {
                        int sum = num[i] + num[j] + num[m] + num[n];
                        if (sum == target) {
                            java.util.List<Integer> list = new java.util.ArrayList<Integer>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[m]);
                            list.add(num[n]);
                            result.add(list);
                            while (m < l - 1 && num[m] == num[++m]);
                            while (n > j + 1 && num[n] == num[--n]);
                        }
                        else if (sum < target) {
                            while (m < l - 1 && num[m] == num[++m]);
                        }
                        else {
                            while (n > j + 1 && num[n] == num[--n]);
                        }
                    }
                }
            }
        }
        return result;
    }
}