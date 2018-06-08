package primeFactor;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

    public static List factor(int number) {
        List result = new ArrayList();
        if (number==2){
            result.add(number);
        }
        return result;
    }
}
