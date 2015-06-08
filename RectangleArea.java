public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C - A) * (D - B) + (G - E) * (H - F) - (A < G && C > E && B < H && D > F ? (
            (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F))): 0
        );
    }
}