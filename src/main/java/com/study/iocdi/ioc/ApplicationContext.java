package com.study.iocdi.ioc;

import com.study.iocdi.aop.MyAspect;

public interface ApplicationContext {

    public Object getBean(String beanName);

    public void registBean(String name, Class<?> clazz);

    public void setAspectj(MyAspect myAspect);
}
