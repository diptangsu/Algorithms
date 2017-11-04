class Knapsack01 {
    public static void main(String args[]) {
        int n = 4;
        int p[] = {0, 1, 4, 5, 7};
        int w[] = {0, 1, 3, 4, 5};
        int m = 7;
        int maxPrice[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < w[i])
                    maxPrice[i][j] = maxPrice[i - 1][j];
                else if (p[i] + maxPrice[i - 1][j - w[i]] > maxPrice[i - 1][j])
                    maxPrice[i][j] = p[i] + maxPrice[i - 1][j - w[i]];
                else
                    maxPrice[i][j] = maxPrice[i - 1][j];
            }
        }
        System.out.println("The maximum profit = " + maxPrice[n][m]);

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(maxPrice[i][j] + " ");
            }
            System.out.println();
        }
    }
}
