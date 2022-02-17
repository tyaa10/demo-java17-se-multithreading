package org.tyaa.demo.java.se.multithreading;

public class SecondWorker implements Runnable {

    private final FirstSharedResource resource;

    private boolean done = false;

    public SecondWorker(FirstSharedResource resource) {
        this.resource = resource;
        new Thread(this).start();
    }

    private static void addStatic () {
        FirstSharedResource.staticCount++;
    }

    private void add () {
        resource.count++;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            add();
            addStatic();
        }
        done = true;
    }
}
