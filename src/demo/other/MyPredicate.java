package demo.other;


import java.util.Objects;

/**
 * Represents a predicate (boolean-valued function) of one argument.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #test(Object)}.
 *
 * @param <T> the type of the input to the predicate
 *
 * @since 1.8
 */
@FunctionalInterface
public interface MyPredicate<T> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t);

    // equals是abstract method, 但是是可以overriding 的
    boolean equals(Object obj);

//     equals也是abstract method, 但是是non-overriding 的, test也是non-overriding 的
//     一个FunctionalInterface里只能有一个non-overriding 的 abstract method
//    boolean equals2(T obj);

    default boolean test2(T t) {return true;};

}