package com.hellojava.traffic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * LampController
 *
 * @author Liu Ran
 */
public class LampController {

    private Lamp currentLamp;
    public LampController() {
        currentLamp = Lamp.S2N;
        start();
    }

    private void start() {
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(() -> {
            currentLamp = currentLamp.blackOut();
        }, 1, 10, TimeUnit.SECONDS);
    }
}
