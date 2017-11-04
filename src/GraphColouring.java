import java.util.Arrays;

class GraphColouring {
    private static int g[][], len, color[], c;

    public static void main(String args[]) {
        /*g = InputMatrix.inputAdjacencyMatrix();
        len = g.length;*/
        len = 3;
        g = new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}};
        color = new int[len];
        c = 3;

        colour(0);
    }

    private static void colour(int k) {
        for (; ; ) {
            nextColor(k);
            if (color[k] == 0)
                return;
            if (k == len - 1)
                System.out.println(Arrays.toString(color));
            else
                colour(k + 1);
        }
    }

    private static void nextColor(int k) {
        int i;
        for (; ; ) {
            color[k] = (color[k] + 1) % (c + 1);
            if (color[k] == 0)
                return;
            for (i = 0; i < len; i++) {
                if (g[k][i] == 1 && color[k] == color[i])
                    break;
            }
            if (i == len)
                return;
        }
    }
}
