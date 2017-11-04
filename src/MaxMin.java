public class MaxMin {
    private static int arr[], max, min;

    public static void main(String args[]) {
        arr = new int[]{23, 43, 5, 12, 98};
        max = min = arr[0];
        getMaxMin(0, arr.length - 1);
        System.out.println("Max = " + max + "\nMin = " + min);
    }

    private static void getMaxMin(int i, int j) {
        int mid, max1, min1;
        if (i == j) {
            max = min = arr[i];
        } else if (i == j - 1) {
            if (arr[i] < arr[j]) {
                max = arr[j];
                min = arr[i];
            } else {
                max = arr[i];
                min = arr[j];
            }
        } else {
            mid = (i + j) / 2;
            getMaxMin(i, mid);
            max1 = max;
            min1 = min;
            getMaxMin(mid + 1, j);
            if (max < max1)
                max = max1;
            if (min > min1)
                min = min1;
        }
    }
}
