package subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutation {


    public static List<List<Integer>> getAllCombination(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int currentNum : num) {

            int n = result.size();
            for (int i = 0; i < n; i++) {
                List<Integer> lst = new ArrayList<>(result.get(i));
                lst.add(currentNum);
                if(!result.contains(lst))
                result.add(lst);
            }
        }
        return result;
    }


}
