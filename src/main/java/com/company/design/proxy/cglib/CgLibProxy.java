package com.company.design.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * spring使用的cglib动态代理，最底层也是用ASM二进制修改的方式生成代理类<br/>
 * 代理类是被代理类的子类
 */
public class CgLibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);//被代理类是代理类的父类
        enhancer.setCallback(new MyInterceptor());
        Tank t = (Tank) enhancer.create();//生成对
        t.move();
    }

}

class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib start");
        Object result = methodProxy.invokeSuper(o, objects);//执行父类的方法，其中o代表的是当前代理类
        System.out.println("cglib start");

        return result;
    }
}

class Tank {
    void move() {
        System.out.println("hong hong hong");
    }
}
