import java.util.Scanner;

public class GraphTraversalsList {
    private static int n;
    private static boolean[] visited;
    private static Vertex vertices[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int g[][] = InputMatrix.inputAdjacencyMatrix();
        n = g.length;
        visited = new boolean[n];
        vertices = new Vertex[n];
        //Create the adjacency list from the adjacency matrix
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
            for (int j = 0; j < n; j++) {
                if (g[i][j] != 0) {
                    addAdjacentVertex(vertices[i], j);
                }
            }
        }

        printAdjacencyList();

        System.out.print("Enter the starting vertex : ");
        int sv = sc.nextInt();
        System.out.print("BFS : ");
        BFS(sv);
        visited = new boolean[n];
        System.out.println();
        System.out.print("DFS : ");
        DFS(sv);
        visited = new boolean[n];
        System.out.println();
        System.out.print("DFS Recursion : ");
        DFSRecursion(sv);
        System.out.println();
    }

    private static void printAdjacencyList() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (Vertex j = vertices[i]; j.adj != null; j = j.adj) {
                System.out.print(j.adj.v + " ");
            }
            System.out.println();
        }
    }

    private static void BFS(int v) {
        Queue q = new Queue(n);
        visited[v] = true;
        System.out.print(v + " ");
        do {
            for (Vertex i = vertices[v]; i.adj != null; i = i.adj) {
                if (!visited[i.adj.v]) {
                    q.enqueue(i.adj.v);
                    System.out.print(i.adj.v + " ");
                    visited[i.adj.v] = true;
                }
            }
            v = q.dequeue();
        } while (v != Integer.MIN_VALUE);
    }

    private static void DFS(int v) {
        Stack s = new Stack(n);
        s.push(v);
        visited[v] = true;
        System.out.print(v + " ");
        while (!s.isEmpty()) {
            int u = s.peek();
            Vertex j;
            for (j = vertices[u]; j.adj != null; j = j.adj) {
                if (!visited[j.adj.v]) {
                    s.push(j.adj.v);
                    visited[j.adj.v] = true;
                    System.out.print(j.adj.v + " ");
                    break;
                }
            }
            if (j.adj == null)
                s.pop();
        }
    }

    private static void DFSRecursion(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Vertex i = vertices[v]; i.adj != null; i = i.adj)
            if (!visited[i.adj.v])
                DFSRecursion(i.adj.v);
    }

    private static void addAdjacentVertex(Vertex vertex, int adjacentVertex) {
        Vertex n = new Vertex(adjacentVertex);
        Vertex i;
        for (i = vertex; i.adj != null; i = i.adj) ;
        i.adj = n;
    }

    static class Vertex {
        int v;
        Vertex adj;

        Vertex(int v) {
            this.v = v;
            adj = null;
        }
    }

    static class Queue {
        int queue[], size, front, rear;

        Queue(int size) {
            this.size = size;
            front = rear = -1;
            queue = new int[size];
        }

        boolean isFull() {
            return rear >= size - 1;
        }

        boolean isEmpty() {
            return front > rear;
        }

        void enqueue(int x) {
            if (front == -1)
                ++front;
            if (!isFull())
                queue[++rear] = x;
        }

        int dequeue() {
            return !isEmpty() ? queue[front++] : Integer.MIN_VALUE;
        }
    }

    static class Stack {
        int stack[], size, top;

        Stack(int size) {
            this.size = size;
            top = -1;
            stack = new int[size];
        }

        boolean isFull() {
            return top >= size - 1;
        }

        boolean isEmpty() {
            return top == -1;
        }

        void push(int x) {
            if (!isFull()) stack[++top] = x;
        }

        int pop() {
            return !isEmpty() ? stack[top--] : Integer.MIN_VALUE;
        }

        int peek() {
            return stack[top];
        }
    }
}