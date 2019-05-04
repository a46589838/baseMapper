package com.tz.basemapper.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConvertUtils {

    public static <I, K, V> Map<K, V> toMap(Collection<I> input, Function<I, K> keyMapper,
                                            Function<I, V> valueMapper) {
        if (input == null) {
            return null;
        }

        return input.stream().collect(Collectors.toMap(keyMapper, valueMapper, (a, b) -> a));
    }

    public static <R, I> Set<R> toSet(Collection<I> input, Function<I, R> mapFunction) {
        return toSet(input, i -> true, mapFunction);
    }

    public static <R, I> List<R> toList(Collection<I> input, Function<I, R> mapFunction) {
        return toList(input, i -> true, mapFunction);
    }

    public static <R, I> Set<R> toSet(Collection<I> input, Predicate<I> filter, Function<I, R> mapFunction) {
        if (input == null) {
            return null;
        }

        return input.stream().filter(filter).map(mapFunction).collect(Collectors.toSet());
    }

    public static <R, I> List<R> toList(Collection<I> input, Predicate<I> filter, Function<I, R> mapFunction) {
        if (input == null) {
            return null;
        }

        return input.stream().filter(filter).map(mapFunction).collect(Collectors.toList());
    }

    public static <I> String toString(Collection<I> input, Function<I, String> mapFunction, String separator) {
        if (input == null) {
            return null;
        }
        return input.stream().map(mapFunction).collect(Collectors.joining(separator));
    }
}
