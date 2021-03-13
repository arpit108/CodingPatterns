package sort;

public class QuickSort {


    public static void sort(int[] num) {
        quickSort(num, 0, num.length-1);
    }

    public static void quickSort(int[] num, int start, int end) {
        if (start < end) {
            int pivot = partition(num, start, end);
            quickSort(num, start, pivot - 1);
            quickSort(num, pivot + 1, end);
        }

    }

    public static int partition(int[] num, int start, int end) {
        int pivot = num[end];
        int low = start - 1;
        for (int i = start; i < end; i++) {
            if (num[i] < pivot) {
                low++;
                swap(num, low, i);
            }
        }
        low++;
        swap(num, low, end);

        return low;

    }

    private static void swap(int[] num, int low, int i) {

        int temp = num[low];
        num[low] = num[i];
        num[i] = temp;
    }


}
