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

        /* FirstSharedResource resource = new FirstSharedResource();
        SecondWorker secondWorker1 = new SecondWorker(resource);
        SecondWorker secondWorker2 = new SecondWorker(resource);
        while (!secondWorker1.isDone() || !secondWorker2.isDone()) {
            Thread.sleep(5);
        }
        System.out.printf("Count = %s, Static Count = %s", resource.count, FirstSharedResource.staticCount); */

        SecondSharedResource resource = new SecondSharedResource();
        /* for (int i = 0; i < 10; i++) {
            resource.printTik();
            resource.printTac();
        } */
        ThirdWorker t1 = new ThirdWorker(resource, 1);
        ThirdWorker t2 = new ThirdWorker(resource, 2);
        Thread.sleep(10);
        // t1.interrupt();
        // t2.interrupt();
        // t1.stop();
        // t2.stop();
        t1.isFinished = true;
        t2.isFinished = true;
        // приостановить поток t1
        // t1.suspend();
        // пробудить поток t1 после приостановки
        // t1.resume();
    }
}
