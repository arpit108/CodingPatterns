package twopointer;

public class RemoveDuplicate {
    public static void main(String[] args) {
       /* int[] arr = {2, 2, 2, 11};
        int index = removeDuplicate(arr);
        System.out.println(index + 1);*/

        ///Remove key

        int[] arrKey = {2, 11, 2, 2, 1};
        int key = 2;
        int index = removeKey(arrKey, key);
        for (int i = 0; i <= index; i++) {
            System.out.print(arrKey[i] + " ");
        }


    }

    private static int removeKey(int[] arrKey, int key) {

       int nonKeyIndex=0;
       for(int i=0;i<arrKey.length;i++)
       {
           if(arrKey[i]!=key)
           {
               arrKey[nonKeyIndex]=arrKey[i];
               nonKeyIndex++;
           }
       }

        return nonKeyIndex-1;

    }

    private static int removeDuplicate(int[] arr) {

        int i = 0, j = 1;
        while (j < arr.length) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            } else {
                j++;
            }
        }
        return i;

    }

}
