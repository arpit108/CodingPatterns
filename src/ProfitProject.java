import java.util.HashMap;

public class ProfitProject {


    public static void main(String[] args) {

        int[] capitals = {0,1,2};
        int[] profits = {1,2,3};
        int numOfProject = 2;
        int initialCapital = 1;

        int result = findMaxProfit(capitals, profits, numOfProject, initialCapital);

        System.out.println(result);
    }

    private static int findMaxProfit(int[] capitals, int[] profits, int numOfProject, int initialCapital) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < capitals.length; i++) {
            map.put(capitals[i], profits[i]);
        }

        int result = initialCapital;

        for (int j = 0; j < numOfProject; j++) {
            int max = Integer.MIN_VALUE;

            for (Integer capital : map.keySet()) {
                if (capital <= result)
                    max = Math.max(max, map.get(capital));
            }

            result += max;


        }

        return result;


    }


}
