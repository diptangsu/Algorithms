import java.util.Scanner;

class InputMatrix {
    static int[][] inputAdjacencyMatrix()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices and the adjacency matrix :");
        int len = sc.nextInt();
        int m[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                m[i][j] = sc.nextInt();
            }
        }
        return m;
    }
}
