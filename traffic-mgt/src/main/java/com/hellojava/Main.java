package com.hellojava;

import com.hellojava.traffic.LampController;
import com.hellojava.traffic.Road;

/**
 * ${NAME}
 *
 * @author Liu Ran
 */
public class Main {
    public static void main(String[] args) {
        /*产生12个方向的路线*/
        String[] directions = {"S2N","S2W","E2W","E2S","N2S","N2E","W2E","W2N","S2E","E2N","N2W","W2S"};
        for (String direction : directions) {
            new Road(direction);
        }

        new LampController();
    }
}
