package io.github.lura.etl.core;

/**
 * @ description: DataTransformer
 * @ author: Liu Ran
 * @ data: 7/7/23 12:36
 */
public interface DataTransformer<O, N> {

    N transform(O oldObj);
}
