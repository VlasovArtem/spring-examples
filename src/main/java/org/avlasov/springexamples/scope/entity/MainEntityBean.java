package org.avlasov.springexamples.scope.entity;

/**
 * Created by artemvlasov on 16/07/2017.
 */
public class MainEntityBean {

    private static final int count = 1;
    private String name;

    public MainEntityBean() {
        name = String.format("%s # %d", this.getClass().getName(), count);
    }

    public String getName() {
        return name;
    }

}
