import java.util.Arrays;

public class FloydWarshall {
    private static int d[][], p[][];
    private static int MAX = 9999;

    public static void main(String args[]) {
        /*len = 4;
        int w[][] = {{0, 5, 7, 6},
                    {-1, 0, 2, MAX},
                    {MAX, 1, 0, 3},
                    {MAX, MAX, 1, 0}};*/
        int w[][] = InputMatrix.inputAdjacencyMatrix();
        int len = w.length;

        if (floydWarshall(w)) {
            for (int i = 0; i < len; i++) {
                System.out.println(Arrays.toString(d[i]));
            }
            System.out.println();
            for (int i = 0; i < len; i++) {
                System.out.println(Arrays.toString(p[i]));
            }
        } else
            System.out.println("Graph has negative cycle/s");

    }

    private static boolean floydWarshall(int w[][]) {
        int len = w.length;
        d = new int[len][len];
        p = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                d[i][j] = w[i][j];
                if (w[i][j] == 0 || w[i][j] == MAX)
                    p[i][j] = -1;
                else
                    p[i][j] = i;
            }
        }

        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++)
                    if (d[i][j] > d[i][k] + d[k][j])
                        d[i][j] = d[i][k] + d[k][j];

                /*for (int m = 0; m < len; m++) {
                    System.out.println(Arrays.toString(d[m]));
                }
                System.out.println();*/
            }
        }

        for (int i = 0; i < len; i++) {
            if (d[i][i] < 0)
                return false;
        }
        return true;
    }
}
