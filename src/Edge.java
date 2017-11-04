class Edge {
    int node1, node2, weight;
    boolean inMST;

    Edge(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
        inMST = false;
    }

    private Edge(Edge x) {
        node1 = x.node1;
        node2 = x.node2;
        weight = x.weight;
        inMST = x.inMST;
    }

    static void printEdges(Edge e[]) {
        for (Edge i : e) {
            System.out.println(i.node1 + "-" + i.node2 + " = " + i.weight);
        }
    }

    static void printEdgesInMST(Edge e[]) {
        for (Edge i : e) {
            if (i.inMST)
                System.out.println(i.node1 + "-" + i.node2 + " = " + i.weight);
        }
    }

    static void sort(Edge e[]) {
        int l = e.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (e[j].weight > e[j + 1].weight) {
                    Edge tmp = new Edge(e[j + 1]);
                    e[j + 1] = new Edge(e[j]);
                    e[j] = new Edge(tmp);
                }
            }
        }
    }
}