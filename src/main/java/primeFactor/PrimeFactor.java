package primeFactor;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

    public static List factor(int number) {
        List result = new ArrayList();
        if (number % 2 == 0) {
            result.add(2);
            number/=2;
            if (number>=2){
                result.add(number);
            }
        }
        if (number%3 == 0){
            result.add(3);
            number/=3;
            if (number>=3){
                result.add(number);
            }
        }

        return result;
    }
}
