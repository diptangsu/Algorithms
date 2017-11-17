import java.util.Scanner;

public class NQueen {
    private static int q[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queens : ");
        int n = sc.nextInt();
        q = new int[n];
        nQueen(0, n);
    }

    private static void nQueen(int k, int n) {
        for (int i = 0; i < n; i++) {
            if (canPlace(k, i)) {
                q[k] = i;
                if (k == n - 1)
                    display();
                nQueen(k + 1, n);
            }
        }
    }

    /**
     * @param k queen
     * @param i position
     * @return true if the k-th queen can be placed at (k, i).
     */
    private static boolean canPlace(int k, int i) {
        for (int j = 0; j < k; j++) {
            if (q[j] == i || Math.abs(j - k) == Math.abs(q[j] - i))
                return false;
        }
        return true;
    }

    private static void display() {
        int n = q.length;
        for (int i : q) {
            for (int j = 0; j < n; j++)
                System.out.print(j == i ? "Q " : ". ");
            System.out.println();
        }
        System.out.println();
    }
}
