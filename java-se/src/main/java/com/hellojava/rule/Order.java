package com.hellojava.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * @ description: Order
 * @ author: Liu Ran
 * @ data: 1/4/23 14:05
 */
@Data
@Accessors(chain = true)
public class Order {
    int price;
    int count;
    String status;
    boolean deleted;
    Product product;

    @Data
    @Accessors(chain = true)
    public static class Product {
        private String name;
    }
}
