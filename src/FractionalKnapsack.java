import java.util.Scanner;

public class FractionalKnapsack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the maximum capacity of the knapsack : ");
        int capacity = sc.nextInt();
        System.out.print("Enter the number of objects : ");
        int n = sc.nextInt();
        KnapsackObject k[] = new KnapsackObject[n];
        System.out.println("Enter the weight and price of each object ;");
        int p, w;
        for (int i = 0; i < n; i++) {
            System.out.println("Object " + (i + 1));
            System.out.print("Weight : ");
            w = sc.nextInt();
            System.out.print("Price : ");
            p = sc.nextInt();
            k[i] = new KnapsackObject(w, p);
        }
        //Sort the objects in a non decreasing order of price/weight
        quickSortKnapsackObjects(k, 0, n - 1);

        for (int i = 0; i < n; i++) System.out.println(k[i]);

        int maxProfit = 0;
        double fraction[] = new double[n];
        int m = capacity;
        int i;
        for (i = 0; i < n; i++) {
            if (m < k[i].weight)
                break;
            fraction[i] = 1;
            m -= k[i].weight;
        }
        if (i <= n) {
            fraction[i] = (double)m / k[i].weight;
        }

        for (i = 0; i < n; i++)
            maxProfit += fraction[i] * k[i].price;

        System.out.println("The maximum profit = " + maxProfit);
    }

    private static void quickSortKnapsackObjects(KnapsackObject arr[], int lower, int upper) {
        if (lower >= upper)
            return;
        int p = partition(arr, lower, upper);
        quickSortKnapsackObjects(arr, lower, p - 1);
        quickSortKnapsackObjects(arr, p + 1, upper);
    }

    private static int partition(KnapsackObject arr[], int lower, int upper) {
        double pivot = arr[upper].pw;
        int j = lower;
        KnapsackObject tmp;
        for (int i = lower; i <= upper; i++) {
            if (arr[i].pw > pivot) {
                tmp = new KnapsackObject(arr[i]);
                arr[i] = new KnapsackObject(arr[j]);
                arr[j] = new KnapsackObject(tmp);
                j++;
            }
        }
        tmp = new KnapsackObject(arr[upper]);
        arr[upper] = new KnapsackObject(arr[j]);
        arr[j] = new KnapsackObject(tmp);

        return j;
    }

    private static class KnapsackObject {
        int weight, price;
        double pw;

        private KnapsackObject() {
            pw = weight = price = 0;
        }

        private KnapsackObject(int weight, int price) {
            this.weight = weight;
            this.price = price;
            pw = (double)price / weight;
        }

        private KnapsackObject(KnapsackObject x) {
            weight = x.weight;
            price = x.price;
            pw = x.pw;
        }

        @Override
        public String toString() {
            return "Weight = " + weight + " Price = " + price + " P/W = " + pw;
        }
    }
}
