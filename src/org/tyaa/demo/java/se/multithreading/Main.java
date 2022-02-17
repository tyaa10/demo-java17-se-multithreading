package org.tyaa.demo.java.se.multithreading;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    // FirstWorker.printCount(100, 1000);
        /* Runnable job1 = () -> {
            try {
                FirstWorker.printCount(100, 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(job1);
        Thread t2 = new Thread(job1);
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        t1.join(5000);
        t2.join(5000);
        System.out.println("The End"); */

        FirstSharedResource resource = new FirstSharedResource();
        SecondWorker secondWorker1 = new SecondWorker(resource);
        SecondWorker secondWorker2 = new SecondWorker(resource);
        while (!secondWorker1.isDone() || !secondWorker2.isDone()) {
            Thread.sleep(5);
        }
        System.out.printf("Count = %s, Static Count = %s", resource.count, FirstSharedResource.staticCount);
    }
}
