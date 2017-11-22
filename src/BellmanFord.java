import java.util.Arrays;
import java.util.Scanner;

class BellmanFord {
    private static final int INF = 9999, NIL = -1;
    private static int g[][], d[], p[], v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        g = InputMatrix.inputAdjacencyMatrix();
        v = g.length;
        d = new int[v];
        p = new int[v];
        for (int i = 0; i < v; i++) {
            d[i] = INF;
            p[i] = NIL;
        }
        System.out.print("Enter the source vertex : ");
        int s = sc.nextInt();
        bellmanFord(s);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(p));
    }

    private static void bellmanFord(int s) {
        d[s] = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (g[i][j] != 0 && d[i] != INF && d[i] + g[i][j] < d[j]) {
                    d[j] = d[i] + g[i][j];
                    p[j] = i;
                }
            }
        }
    }
}