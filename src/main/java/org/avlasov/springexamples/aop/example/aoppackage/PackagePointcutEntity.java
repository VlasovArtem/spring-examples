package org.avlasov.springexamples.aop.example.aoppackage;

import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 23/08/2018
 **/
@Component
public class PackagePointcutEntity {

    public String first() {
        return "first";
    }

    protected String second() {
        return "second";
    }

    String third() {
        return "third";
    }

}
