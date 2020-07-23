package com.company.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 拌面
 * @date 2020/7/16
 * @description
 */

public class ObserverTest {

    public static void main(String[] args) {
        Children children = new Children();
        children.list.add(new Dad());
        children.list.add(new Mom());

        children.cry();
    }
}


abstract class Event<T> {
    abstract T getSource();
}

class CryEvent extends Event<Children> {

    public String timeStamp;
    public String local;
    public Children children;

    @Override
    Children getSource() {
        return children;
    }
}


class Children {

    private boolean cry = false;

    public List<Observer> list = new ArrayList<>();


    public void cry() {
        CryEvent cryEvent = new CryEvent();
        cryEvent.children = this;
        cryEvent.local = "bed";
        for (Observer o : list) {
            o.actionObserver(cryEvent);
        }
    }

}


interface Observer {

    void actionObserver(Event event);
}

class Mom implements Observer {

    @Override
    public void actionObserver(Event event) {
        System.out.println("dad ......");
    }
}


class Dad implements Observer {

    @Override
    public void actionObserver(Event event) {
        System.out.println("mom ......");
    }
}