package com.TemplateDesign;

abstract public class Template {
    public abstract  void job();
    public void cal(){
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("运行时间\t"+(end -start));
    }
}
