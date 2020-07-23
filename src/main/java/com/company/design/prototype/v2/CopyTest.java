package com.company.design.prototype.v2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CopyTest {

    public static void main(String[] args) throws InterruptedException {
        Person p = new Person();
        p.setAge(23);
        p.setBirthday(new Date());
        p.setName("tome");
        Location location = new Location();
        location.setNum(420);
        location.setStreet("秦皇岛大街");
        p.setLocation(location);

        TimeUnit.SECONDS.sleep(10);
        try {
            Person p1 = (Person) p.clone();
            p1.setName("jack");
            p1.setAge(10);
            p1.setBirthday(new Date());
            p1.getLocation().setStreet("昌黎大街");
            System.out.println(p);
            System.out.println(p1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}

/**
 * 实现cloneable接口，重写clone方法
 */
class Person implements Cloneable {


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p= (Person) super.clone();
        p.setLocation((Location) getLocation().clone());
        return p;
    }


    private int age;

    private Date birthday;

    private String name;

    private Location location;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", birthday=" + birthday +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}

class Location implements Cloneable{


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String street;

    private int num;

    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", num=" + num +
                '}';
    }
}