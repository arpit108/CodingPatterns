package twopointer;

public class SquareOfNumber {

    public static void main(String[] args) {
        int[] arr = {-3, -1, 0, 1, 2};
        int[] result = getSquareArr(arr);
        for (Integer element : result)
            System.out.print(element + " ");
    }

    private static int[] getSquareArr(int[] arr) {

        int leftSquare = 0;
        int rightSquare = 0;
        int left = 0, right = arr.length - 1;
        int[] result = new int[arr.length];
        int highestIndex = arr.length - 1;
        while (left < right) {
            leftSquare = arr[left] * arr[left];
            rightSquare = arr[right] * arr[right];

            if (leftSquare > rightSquare) {
                result[highestIndex] = leftSquare;
                left++;
            } else {
                result[highestIndex] = rightSquare;
                right--;
            }
            highestIndex--;

        }
        return result;


    }


}
