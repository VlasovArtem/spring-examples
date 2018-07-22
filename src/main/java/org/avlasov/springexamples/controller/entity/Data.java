package org.avlasov.springexamples.controller.entity;

/**
 * Created By artemvlasov on 22/07/2018
 **/
public class Data {

    private String firstText;
    private String secondText;

    public Data() {
    }

    public Data(String firstText, String secondText) {
        this.firstText = firstText;
        this.secondText = secondText;
    }

    public String getFirstText() {
        return firstText;
    }

    public String getSecondText() {
        return secondText;
    }
}
