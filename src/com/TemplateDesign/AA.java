package com.TemplateDesign;

public class AA extends Template {
    public void job() {
        long num = 0;
        for (long i = 0; i < 8000000; i++) {
            num += i;
        }
    }
}
