package com.compare.products.template;

public class GeminiHelper {
    private String apiKey;
    private String model;
    private TestTemplate test;
    public GeminiHelper(){
        this.test=new TestTemplate();

    }

    public GeminiHelper(String apiKey, String model) {
        this.apiKey = apiKey;
        this.model = model;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TestTemplate getTest() {
        return test;
    }
}
