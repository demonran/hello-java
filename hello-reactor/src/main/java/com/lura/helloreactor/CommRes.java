package com.lura.helloreactor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommRes<T> {
    private Void data;
}
