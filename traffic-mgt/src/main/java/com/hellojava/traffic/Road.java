package com.hellojava.traffic;

import com.hellojava.observer.Observer;
import com.hellojava.observer.Subject;
import com.hellojava.traffic.message.LightMessage;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Load
 *
 * @author Liu Ran
 */
public class Road implements Observer {
    private final String name;

    private final LinkedList<String> vehicles;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public Road(String name) {
        this.name = name;
        this.vehicles = new LinkedList<>();
        System.out.println("创建道路：" + name);
        // 非右转车道加入观察
        if (Lamp.valueOf(name).isLighted()) {
            this.cross();
        }else {
            Subject.INSTANCE.attach(this);
        }
        onRoad();
    }

    private void onRoad() {
        System.out.println("车开始上路。。。");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            int i = 1;
            while (true) {
                try {
                    Thread.sleep((new Random().nextInt(10) + 1) * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 增加车辆
                String vehicle = this.name + "_" + i;
                vehicles.add(vehicle);
//                System.out.println("增加车辆:" + vehicle);
                i++;
            }
        });
    }

    private void cross() {
        // 车辆通过路口
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(() -> { // 开始通行
            if (vehicles.size() > 0) {
                // 车辆通过路口
                String vehicle = vehicles.removeFirst();
                System.out.println(vehicle + " 正在通过");
            }

        }, 1, 1, TimeUnit.SECONDS);
    }

    @Override
    public void update(Object msg) {
        if (msg instanceof LightMessage message) {  // 绿灯亮了
            if (message.lamp().name().equals(this.name)) { // 当前道路的绿灯亮了
                System.out.println(name + "绿灯开始通行");
                this.cross();
            } else {
                if (!scheduledExecutorService.isShutdown()) {
                    scheduledExecutorService.shutdown();
                }
            }
        }
    }
}
