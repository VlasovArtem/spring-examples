package org.avlasov.springexamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created By artemvlasov on 26/08/2018
 **/
public class TestFunction {

    public static void main(String[] args) {
        Function<String, Boolean> test1 = (one) -> {
            System.out.println("Test 1");
            return Boolean.valueOf(one);
        };
        Function<String, Boolean> test2 = (two) -> {
            System.out.println("Test 2");
            return Boolean.valueOf(two);
        };
        List<Function<String, Boolean>> functions = Arrays.asList(test1, test2);
        boolean test = !functions.get(1).apply("test");
    }

}
