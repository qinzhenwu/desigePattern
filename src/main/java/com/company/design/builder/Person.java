package com.company.design.builder;

public class Person {
    int age;

    String name;

    String sex;

    Location location;

    private Person() {

    }

    public static class PersonBuilder {
        private Person person = new Person();

        public PersonBuilder baseInfo(String name, int age, String sex) {
            person.age = age;
            person.name = name;
            person.sex = sex;
            return this;
        }

        public PersonBuilder localInfo(String street, String num) {
            Location location = new Location(street, num);
            person.location = location;
            return this;
        }

        public Person build() {
            return person;
        }


    }


    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", location=" + location +
                '}';
    }
}


class Location {
    private String street;

    private String num;

    public Location(String street, String num) {
        this.num = num;
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public String getNum() {
        return this.num;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}

