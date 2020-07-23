package com.company.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理，被代理的对象必须要实现一个接口，这个Proxy类限制的<br/>
 * 通过反射的方式获取被代理的class，然后使用ASM对二进制码进行修改产生新的代理对象<br/>
 * 重新生成的代理类也是实现对应的接口，在接口方法中调用InvocationHandler的invoke方法，
 * 而在实现InvocationHandler的类中，invoke方法调用就是被代理对象的方法。
 */
public class JdkProxy {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");//生成动态代理对象开关
        /**
         * 第一个参数，被代理类的类加载器，第二个，被代理类的实现的接口，第三个，实现InvocationHandler接口的实现类，处理具体的代理业务
         */
        Movable proxy = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new TankProxy());

        proxy.move();
    }

}

class TankProxy implements InvocationHandler {

    private Movable movable;

    public TankProxy() {
        movable = new Tank();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        method.invoke(movable, args);//执行被代理对象的方法
        System.out.println("end");
        return null;
    }
}


interface Movable {

    void move();

}

class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("myTank lalalalala ....");
    }
}

