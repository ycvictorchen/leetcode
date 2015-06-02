public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int result = 0;
        java.util.Map<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if (!map.containsKey(num[i])) {
                int lc = map.containsKey(num[i] - 1) ? map.get(num[i] - 1) : 0;
                int rc = map.containsKey(num[i] + 1) ? map.get(num[i] + 1) : 0;
                int tt = lc + rc + 1;
                map.put(num[i], tt);
                if (lc > 0) {
                    map.put(num[i] - lc, tt);
                }
                if (rc > 0) {
                    map.put(num[i] + rc, tt);
                }
                result = Math.max(result, tt);
            }
        }
        return result;
    }
}