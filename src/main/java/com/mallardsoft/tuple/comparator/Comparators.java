package com.mallardsoft.tuple.comparator;

import java.util.Comparator;

import com.mallardsoft.tuple.End;
import com.mallardsoft.tuple.Tuple;

public class Comparators
{
    /**
     * Create a tuple compatator that will compare a <code>Pair</code> tuple
     * against other tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Pair</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Pair</code> tuple.
     * @param pair
     *            The <code>Pair</code> tuple.
     * @return An ordered tuple form the given single tuple.
     */
    public static
        <A extends Comparable<A>, B extends Comparable<B>>
        Comparator<Tuple<A, Tuple<B, End>>> pair(Class<A> typeA, Class<B> typeB)
    {
        return TupleComparator.<B>last().<A>prepend();
    }
}
