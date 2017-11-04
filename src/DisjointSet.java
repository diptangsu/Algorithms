import java.util.Arrays;

public class DisjointSet {
    int set[];

    DisjointSet(int x) {
        set = new int[x];
        for (int i = 0; i < set.length; i++) {
            set[i] = -1;
        }
    }

    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet(7);

        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);
        ds.union(5, 6);
        ds.union(4, 5);
        ds.union(2, 6);

        System.out.println(Arrays.toString(ds.set));

        System.out.println(ds.find(0));
        System.out.println(ds.find(1));
        System.out.println(ds.find(2));
        System.out.println(ds.find(3));
        System.out.println(ds.find(4));
        System.out.println(ds.find(5));
        System.out.println(ds.find(6));
    }

    /**
     * @param x node
     * @return the root of node x
     */
    int find(int x) {
        while (set[x] >= 0)
            x = set[x];
        return x;
    }

    /**
     * @param x node
     * @param y node
     *          root of x becomes the root of y.
     */
    void union(int x, int y) {
        /*if (set[y] < 0)
            set[y] = find(x);
        else
            set[x] = find(y);*/
        set[find(y)] = find(x);
    }
}
