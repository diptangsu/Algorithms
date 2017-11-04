public class Dijkstra {
    private static boolean edgeInMST[];
    private static int g[][], n, parent[], minWeight[];

    public static void main(String args[]) {
        g = InputMatrix.inputAdjacencyMatrix();
        n = g.length;
        parent = new int[n];
        minWeight = new int[n];
        edgeInMST = new boolean[n];
        dijkstra();
        System.out.println("The edges present in the Minimum Spanning Tree are :");
        printShortestPath();
    }

    private static void dijkstra() {
        int u;
        //Make all weights infinity and all parent nodes null
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            minWeight[i] = Integer.MAX_VALUE;
        }
        minWeight[0] = 0;
        for (int i = 0; i < n; i++) {
            u = minWeightEdge();
            edgeInMST[u] = true;
            for (int v = 0; v < n; v++) {
                if (g[u][v] != 0 && !edgeInMST[v] && minWeight[v] > g[u][v] + minWeight[u]) {
                    parent[v] = u;
                    minWeight[v] = minWeight[u] + g[u][v];
                }
            }
        }
    }

    private static int minWeightEdge() {
        int min = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < n; i++) {
            if (!edgeInMST[i] && minWeight[i] < min) {
                min = minWeight[i];
                ind = i;
            }
        }
        return ind;
    }

    private static void printShortestPath() {
        System.out.println(0 + " = " + minWeight[0]);
        for (int i = 1; i < n; i++) {
            if (edgeInMST[i])
                System.out.println(parent[i] + "-" + i + " = " + minWeight[i]);
        }
    }
}
