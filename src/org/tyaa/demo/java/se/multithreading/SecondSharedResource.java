package org.tyaa.demo.java.se.multithreading;

/**
 * Класс для создания объектов,
 * на которых следует вызывать метод printTik,
 * когда состояние объекта равно 1,
 * или метод printTac, когда состояние равно 2
 * */
public class SecondSharedResource {

    /** поле состояния объекта, может принимать значение 1 или 2 */
    private Integer state = 1;

    public void printTik () {
        System.out.print("tik-");
        state = 2;
    }
    public void printTac () {
        System.out.print("tac!\n");
        state = 1;
    }

    public Integer getState() {
        return state;
    }
}
