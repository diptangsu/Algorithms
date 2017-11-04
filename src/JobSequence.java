import java.util.Scanner;

public class JobSequence {
    private static int profit[], deadline[], job[], jobOrder[], n;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of jobs : ");
        n = sc.nextInt();
        profit = new int[n + 1];
        deadline = new int[n + 1];
        job = new int[n + 1];
        jobOrder = new int[n + 1];

        for (int i = 0; i < n + 1; i++)
            jobOrder[i] = -1;

        System.out.println("Enter the profit and deadline for the i-th job :");
        System.out.println("Profit Deadline");
        for (int i = 1; i < n + 1; i++) {
            profit[i] = sc.nextInt();
            deadline[i] = sc.nextInt();
            job[i] = i;
        }

        sortProfit();
        printJobs();
        maxProfitJobOrder();
        System.out.print("Job order for maximum profit : ");
        printJobOrder();
    }

    private static void maxProfitJobOrder() {
        jobOrder[0] = 0;
        jobOrder[1] = 1;
        int k = 1, r;
        for (int i = 2; i <= n; i++) {
            r = k;
            while (deadline[jobOrder[r]] > deadline[i] && deadline[jobOrder[r]] != r)
                r--;
            if (deadline[jobOrder[r]] <= deadline[i] && deadline[i] > r) {
                for (int j = k; j >= r + 1; j--)
                    jobOrder[j + 1] = jobOrder[j];
                jobOrder[r + 1] = i;
                k += 1;
            }
        }
    }

    private static void sortProfit() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i - 1; j++) {
                if (profit[j] < profit[j + 1]) {
                    swap(profit, j, j + 1);
                    swap(deadline, j, j + 1);
                    swap(job, j, j + 1);
                }
            }
        }
    }

    private static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void printJobOrder() {
        for (int i = 1; i < n + 1; i++) {
            if (jobOrder[i] != -1)
                System.out.print(job[jobOrder[i]] + " ");
        }
        System.out.println();
    }

    private static void printJobs() {
        System.out.println("Job\tProfit\tDeadline");
        for (int i = 1; i < n + 1; i++) {
            System.out.println(job[i] + "\t" + profit[i] + "\t\t" + deadline[i]);
        }
    }
}
/*
Sample Input
6
70 2
100 1
200 2
50 3
71 3
80 4

Sample output
Job Order: 2 3 5 6
 */