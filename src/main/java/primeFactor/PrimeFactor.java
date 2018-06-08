package primeFactor;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

    public static List factor(int number) {
        List result = new ArrayList();

        for (int i=2;i<=number;i++){
            while (number % i == 0) {
                result.add(i);
                number/=i;
            }
        }
        return result;
    }
}
