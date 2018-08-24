package org.avlasov.springexamples.aop.example.aopsubpackage;

import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 23/08/2018
 **/
@Component
public class PackageEntity {

    public String packageMethod() {
        return "package";
    }

}
