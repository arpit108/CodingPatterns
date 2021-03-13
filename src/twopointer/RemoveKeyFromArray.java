package twopointer;

public class RemoveKeyFromArray {

    public static void main(String[] args) {
        int[] arr = {2, 11, 2, 2, 1};
        int key = 2;

        int newLength = removeKey(arr, key);
        System.out.println(newLength);


    }

    private static int removeKey(int[] arr, int key) {

        int i = 0, j = 0;

        while (j < arr.length) {
            if (arr[j] == key) {
                j++;
            } else {
                arr[i] = arr[j];
                j++;
                i++;
            }


        }


        return i ;

    }

}
