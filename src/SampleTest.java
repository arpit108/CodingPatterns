import java.util.Arrays;

public class SampleTest {

    public static void main(String[] args) {

        //15124  15142  15214  15241  15412 15421

        int num = 1514;
        int result = findNextNumber(num);
        System.out.println("Next number= " + result);

    }

    private static int findNextNumber(int num) {
        String str = num + "";
        char[] charArr = str.toCharArray();
        int result = 0;
        int smallIndex=-1;
        int i=-1;
        for (i = charArr.length - 1; i >0; i--) {
            if (charArr[i] > charArr[i - 1]) {
                smallIndex = findSmallIndex(charArr, i, i - 1);
                break;
            }
        }

        if(smallIndex<0)
            return -1;
        swap(charArr,i-1,smallIndex);
        Arrays.sort(charArr,i,charArr.length-1);

        StringBuilder sb=new StringBuilder(charArr.length);
        for(Character element:charArr)
        {
            sb.append(element);
        }


        return Integer.parseInt(sb.toString());
    }

    private static int findSmallIndex(char[] charArr, int minIndex, int minNumIndex) {

        for(int j=minIndex+1;j<charArr.length;j++)
        {
            if(charArr[j]>charArr[minNumIndex] && charArr[j]<charArr[minIndex])
            {
                minIndex=j;
            }
        }

        return minIndex;


    }

    public static void  swap(char[] charArr, int firstIndex, int secondIndex) {
        char temp = charArr[firstIndex];
        charArr[firstIndex] = charArr[secondIndex];
        charArr[secondIndex] = temp;

    }


}
