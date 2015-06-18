public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int l = nums.length;
        String[] arr = new String[l];
        for (int i = 0; i < l; i++) {
            arr[i] = nums[i] + "";
        }
        java.util.Arrays.sort(arr, new java.util.Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        if (arr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}