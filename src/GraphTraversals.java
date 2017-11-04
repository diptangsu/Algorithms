import java.util.Scanner;

public class GraphTraversals {
    private static int g[][], n, visited[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        g = InputMatrix.inputAdjacencyMatrix();
        n = g.length;
        System.out.print("Enter the node from which you want to display the Depth and Breadth First Traversal : ");
        int v = sc.nextInt();
        visited = new int[n];
        System.out.print("DFS : ");
        DFS(v);
        System.out.println();
        visited = new int[n];
        System.out.print("DFS using recursion : ");
        DFSRecursion(v);
        System.out.println();
        visited = new int[n];
        System.out.print("BFS : ");
        BFS(v);
        System.out.println();
    }

    private static void DFS(int v) {
        int i;
        Stack s = new Stack(n);
        s.push(v);
        visited[v] = 1;
        System.out.print(v + " ");
        while (!s.isEmpty()) {
            v = s.peek();
            for (i = 0; i < n; i++) {
                if (g[v][i] != 0 && visited[i] == 0) {
                    s.push(i);
                    visited[i] = 1;
                    System.out.print(i + " ");
                    break;
                }
            }
            if (i == n)
                s.pop();
        }
    }

    private static void DFSRecursion(int v) {
        visited[v] = 1;
        System.out.print(v + " ");
        for (int i = 0; i < n; i++) {
            if (g[v][i] != 0 && visited[i] == 0)
                DFSRecursion(i);
        }
    }

    private static void BFS(int v) {
        Queue q = new Queue(n);
        visited[v] = 1;
        System.out.print(v + " ");
        do {
            for (int i = 0; i < n; i++) {
                if (g[v][i] == 1 && visited[i] == 0) {
                    q.enqueue(i);
                    visited[i] = 1;
                    System.out.print(i + " ");
                }
            }
            v = q.dequeue();
        } while (v != Integer.MIN_VALUE);
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
