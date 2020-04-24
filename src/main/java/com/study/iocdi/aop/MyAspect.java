package com.study.iocdi.aop;

public class MyAspect {

    private   MyAdvice  myAdvice;
    private   MyPointCut  myPointCut;

    public MyAspect(MyAdvice myAdvice, MyPointCut myPointCut) {
        this.myAdvice = myAdvice;
        this.myPointCut = myPointCut;
    }

    public MyAdvice getMyAdvice() {
        return myAdvice;
    }

    public void setMyAdvice(MyAdvice myAdvice) {
        this.myAdvice = myAdvice;
    }

    public MyPointCut getMyPointCut() {
        return myPointCut;
    }

    public void setMyPointCut(MyPointCut myPointCut) {
        this.myPointCut = myPointCut;
    }
}
