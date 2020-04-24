package com.study.iocdi.aop;

public class MyPointCut {
    private String   classPart ;
    private String   methodPart ;


    public MyPointCut(String classPart, String methodPart) {
        this.classPart = classPart;
        this.methodPart = methodPart;
    }

    public String getMethodPart() {
        return methodPart;
    }

    public void setMethodPart(String methodPart) {
        this.methodPart = methodPart;
    }

    public String getClassPart() {
        return classPart;
    }

    public void setClassPart(String classPart) {
        this.classPart = classPart;
    }
}
