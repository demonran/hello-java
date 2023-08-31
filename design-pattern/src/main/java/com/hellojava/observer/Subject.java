package com.hellojava.observer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Subject
 *
 * @author Liu Ran
 */
public class Subject {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public final static Subject INSTANCE = new Subject();

    private final List<Observer> observers = new LinkedList<>();

    public void attach(Observer observer) {
        System.out.println("加入观察：" + observers.size());
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notify(Object msg) {
        observers.forEach(it -> executorService.submit(() -> it.update(msg)));
    }
}
