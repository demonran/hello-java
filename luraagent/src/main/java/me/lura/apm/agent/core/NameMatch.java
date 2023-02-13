package me.lura.apm.agent.core;

/**
 * @ description: TODO
 * @ author: Liu Ran
 * @ data: 10/30/22 17:40
 */
public class NameMatch implements ClassMatch {

    private String className;

    public NameMatch(String className) {
        this.className = className;
    }

    public static NameMatch byName(String className) {
        return new NameMatch(className);
    }
}
