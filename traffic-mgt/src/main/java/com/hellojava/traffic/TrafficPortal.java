package com.hellojava.traffic;

/**
 * TrafficPortal
 *
 * @author Liu Ran
 */
public class TrafficPortal {
    public static void start() {
        /*产生12个方向的路线*/
        String[] directions = {"S2N","S2W","E2W","E2S","N2S","N2E","W2E","W2N","S2E","E2N","N2W","W2S"};
        for (String direction : directions) {
            new Road(direction);
        }

        new LampController();
    }
}
