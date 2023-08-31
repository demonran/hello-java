package com.hellojava.traffic;

import com.hellojava.observer.Subject;
import com.hellojava.traffic.message.BlackOutMessage;
import com.hellojava.traffic.message.LightMessage;

/**
 * Lamp
 *
 * @author Liu Ran
 */
public enum Lamp {
    S2N("N2S", "S2W", false), S2W("N2E", "W2E", false), S2E(null, null, true),
    N2S(null, null, false), N2W(null, null, true), N2E(null, null, false),
    W2E("E2W", "W2N", false), W2S(null, null, true), W2N("E2S", "S2N", false),
    E2W(null, null, false), E2S(null, null, false), E2N(null, null, true);

    private String next;
    private String opposite;
    private boolean lighted;

    Lamp(String opposite, String next, boolean lighted) {
        this.next = next;
        this.opposite = opposite;
        this.lighted = lighted;
    }

    public void light() {
        Subject.INSTANCE.notify(new LightMessage(this));
        System.out.println(this.name() + " 亮了");
        this.lighted = true;
        if (opposite != null) {
            Lamp.valueOf(opposite).light();
        }
    }

    public boolean isLighted() {
        return lighted;
    }

    public Lamp blackOut() {
        Subject.INSTANCE.notify(new BlackOutMessage(this));
        this.lighted = false;
        if (opposite != null) {
            Lamp.valueOf(opposite).blackOut();
        }
        Lamp nextLamp = null;
        if (next != null) {
            nextLamp = Lamp.valueOf(next);
            nextLamp.light();
        }
        return nextLamp;
    }
}
