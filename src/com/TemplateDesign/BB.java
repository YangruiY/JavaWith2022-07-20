package com.TemplateDesign;

public class BB extends Template{
    long Num = 0;
    public void job(){
        for (long i = 1; i < 8000000; i++) {
            Num  = Num *  i ;
        }

    }
}
