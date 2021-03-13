package twopointer;

public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 11};

        int result = removeDuplicates(arr);
        System.out.println(result);


    }

    private static int removeDuplicates(int[] arr) {

        int slow = 0;
        int fast = 1;

        while (fast < arr.length) {
            if (arr[slow] == arr[fast]) {
                fast++;
            } else {
                slow++;
                arr[slow] = arr[fast];
            }


        }
    return slow+1;

    }


}
