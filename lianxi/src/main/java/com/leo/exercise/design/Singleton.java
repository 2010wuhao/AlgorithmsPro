package com.leo.exercise.design;

public class Singleton {

    private Singleton() {
    }

    //1、推荐的写法，既保证了再加载类的时候不会创建实例，又保证了线程安全和获取实例时候的高效
    private static class SingleonBuild {
        private static final Singleton sInstance = new Singleton();
    }
//    public static Singleton getInstance() {
//        return SingleonBuild.sInstance;
//    }

    //2、volatile 保证在new Singleton后其他线程立刻可见
//    private static volatile Singleton sInstance;
//    public static Singleton getInstance() {
//        if (mINSTANCE == null) {
//            //在第二次判断才加锁为了保证多次访问的效率
//            synchronized (Singleton.class) {
//                if (sInstance == null) {
//                    sInstance = new Singleton();
//                }
//            }
//        }
//        return sInstance;
//    }

    //3、饿汉式
    private static final Singleton sInstance = new Singleton();
    public static Singleton getInstance() {
        return sInstance;
    }
}
