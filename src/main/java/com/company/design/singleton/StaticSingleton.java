package com.company.design.singleton;

public class StaticSingleton {

    private StaticSingleton() {

    }

    private static class SS {
        private static final StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SS.instance;
    }


    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            new Thread(()->{
                StaticSingleton staticSingleton=StaticSingleton.getInstance();
                System.out.println(staticSingleton.hashCode());
            }).start();
        }
    }
}
