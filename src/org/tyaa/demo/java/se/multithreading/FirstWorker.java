package org.tyaa.demo.java.se.multithreading;

public class FirstWorker {

    public static void printCount (Integer a, Integer b) throws InterruptedException {
        /* for (int i = a; i <= b; i++) {
            System.out.printf("#%s (From %s)\n", i, Thread.currentThread().getName());
        } */
        while (true) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);
        }
    }
}
