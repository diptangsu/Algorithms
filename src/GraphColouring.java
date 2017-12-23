import java.util.Arrays;
import java.util.Scanner;

class GraphColouring {
    private static int g[][], len, color[], c;

    public static void main(String args[]) {
        /*g = InputMatrix.inputAdjacencyMatrix();*/
        Scanner sc = new Scanner(System.in);
        g = new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}};
        len = g.length;
        color = new int[len];
        System.out.print("Enter the number of colours available : ");
        c = sc.nextInt();

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
