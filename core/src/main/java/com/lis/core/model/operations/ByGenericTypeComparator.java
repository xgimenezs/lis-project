package com.lis.core.model.operations;

import org.springframework.core.GenericTypeResolver;

import java.util.Comparator;

/**
 * Created by xgimenez on 8/3/18.
 *
 This utility class simply provides a comparator to sort a list of generic operations, ensuring that for each item in
 the list there is no more specific item with a greater index in the list.
 */
class ByGenericTypeComparator implements Comparator<IOperation> {

    public int compare(IOperation o1, IOperation o2) {
        Class<?> c1 = GenericTypeResolver.resolveTypeArgument(o1.getClass(), IOperation.class);
        Class<?> c2 = GenericTypeResolver.resolveTypeArgument(o2.getClass(), IOperation.class);
        return c1.isAssignableFrom(c2) ? 1 :(c2.isAssignableFrom(c1) ? -1 : 0);
    }
}
