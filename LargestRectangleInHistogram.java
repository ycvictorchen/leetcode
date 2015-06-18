public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<Integer>();
        for (int i = 0, l = height.length; i <= l; i++) {
            while (!stack.isEmpty() && (i == l || height[stack.peek()] > height[i])) {
                int idx = stack.pop();
                result = Math.max(result, height[idx] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
            if (i < l) {
                stack.push(i);
            }
        }
        return result;
    }
}