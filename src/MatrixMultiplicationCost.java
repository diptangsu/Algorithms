public class MatrixMultiplicationCost {
    private static int arr[], m[][], s[][];

    public static void main(String args[]) {
        MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
        //int arr[] = {4, 2, 3, 5, 3};
        //int arr[] = {2, 3, 6, 4, 5};
        arr = new int[]{20, 5, 10, 20, 30};
        int cost = mmc.findCost(arr);
        System.out.println(cost);
        POP(1, arr.length - 1);
    }

    private static void POP(int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        }
        else {
            System.out.print("(");
            POP(i, s[i][j]);
            POP(s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    private int findCost(int arr[]) {
        m = new int[arr.length][arr.length];
        s = new int[arr.length][arr.length];
        int q, len = arr.length;
        for (int l = 2; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    q = m[i][k] + m[k][j] + arr[i] * arr[k] * arr[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i + 1][j] = k;
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.printf("%5d ", m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return m[0][len - 1];
    }
}
