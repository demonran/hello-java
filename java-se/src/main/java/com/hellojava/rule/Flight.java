package com.hellojava.rule;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ description: Flight
 * @ author: Liu Ran
 * @ data: 1/5/23 09:39
 */
@Builder
@Getter
public class Flight {
    /**
     * 客梯车（同时满足）：
     * 1. 远机位： F.stand.type
     * 2. 排除某些机位： !("201","301").contains(F.stand.code)
     * 3. ["W/Z","A/B"].contains(F.task)
     * 4. ["3A","CA"].contains.(F.airline.code)
     * 5. ["过站","航前"].anyMatch(F.tags)
     * 6. F.过站时长> 10 && F.过站时长 < 50
     */

    private String task;
    private Airline airline;
    private List<String> tags;
    private double standingTime;
    private Stand stand;

    @Data
    @Value(staticConstructor = "of")
    public static class Airline {
        String code;
    }

    @Value(staticConstructor = "of")
    @Accessors(chain = true)
    public static class Stand {
        private String type;
        private String code;
    }

    public boolean isContainsStandCode(List<String> stands) {
        return stands.contains(stand.code);
    }

    public boolean tagContains(List<String> matchTags) {
        return tags.stream().anyMatch(matchTags::contains);
    }
}
