public class Kruskal {
    private static int g[][], n, e;
    private static Edge edges[];

    public static void main(String args[]) {
        g = InputMatrix.inputAdjacencyMatrix();
        n = g.length;
        //find out the number of edges in the graph and store it in e:int
        e = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (g[i][j] != 0)
                    ++e;
            }
        }

        kruskalMST();
        System.out.println("The edges present in the Minimum Spanning Tree are :");
        Edge.printEdgesInMST(edges);
    }

    private static void makeEdgesSet() {
        //Create an array containing all edges and their weights
        edges = new Edge[e];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (g[i][j] != 0)
                    edges[k++] = new Edge(j, i, g[i][j]);
            }
        }
    }

    private static void kruskalMST() {
        makeEdgesSet();
        //Sort the array of edges in an order of their non decreasing weights
        Edge.sort(edges);
        //Edge.printEdges(edges);

        //Create a disjoint set containing all vertices
        DisjointSet ds = new DisjointSet(n);
        for (Edge edge : edges) {
            //System.out.println("Root of (" + edge.node1 + ", " + edge.node2 + ") -> (" + ds.find(edge.node1) + ", " + ds.find(edge.node2) + ")");
            if (ds.find(edge.node1) != ds.find(edge.node2)) {
                ds.union(edge.node1, edge.node2);
                edge.inMST = true;
                //System.out.println(Arrays.toString(ds.set));
            }
        }
    }
}
