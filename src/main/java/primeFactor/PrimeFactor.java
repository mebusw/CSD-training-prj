package primeFactor;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

    public static List<Integer> factor(int number) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=2;i<=number;i++){
            while (number % i == 0) {
                result.add(i);
                number/=i;
            }
        }
        return result;
    }
}
