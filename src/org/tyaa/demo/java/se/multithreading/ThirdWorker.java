package org.tyaa.demo.java.se.multithreading;

import java.util.Objects;

/**
 * Класс для создания объектов, работающих каждый в своем отдельном потоке.
 * Каждому объекту дается ссылка на ресурс, на котором можно вызвать один из двух методов,
 * в зависимости от состояния ресурса,
 * а также идентификатор объекта-работника:
 * если он равен 1 - этот работник должен вызывать на ресурсе первый метод,
 * иначе - второй, при соответствующем состоянии ресурсе.
 * */
public class ThirdWorker extends Thread {

    private final SecondSharedResource resource;
    private final Integer id;
    public volatile Boolean isFinished;

    public ThirdWorker(SecondSharedResource resource, Integer id) {
        this.resource = resource;
        this.id = id;
        this.isFinished = false;
        this.start();
    }

    @Override
    public void run() {
        // super.run();
        for (int i = 0; i < 100; i++) {
            if (!this.isFinished) {
                synchronized (resource) {
                    // если сейчас состояние ресурса не совпадает с идентификатором текущего работника
                    while (!Objects.equals(id, resource.getState())) {
                        try {
                            // уступаем ход другому потоку
                            resource.wait(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // иначе - приступаем к работе.
                    // если идентификатор текущего работника - 1,
                    // то вызываем на ресурсе первый метод
                    if (id.equals(1)) {
                        System.out.print(i + ". ");
                        resource.printTik();
                    } else if (id.equals(2)) {
                        // иначе - второй
                        resource.printTac();
                    }
                    // сообщаем ближайшему потоку,
                    // что выполнили работу,
                    // и теперь он может претендовать на получение времени
                    resource.notify();
                    // или сообщаем об этом всем ожидающим потокам,
                    // если их несколько
                    // resource.notifyAll();
                }
            } else {
                break;
            }
        }
    }
}
