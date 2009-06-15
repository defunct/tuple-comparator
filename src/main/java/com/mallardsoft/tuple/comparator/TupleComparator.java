package com.mallardsoft.tuple.comparator;

import java.util.Comparator;

import com.mallardsoft.tuple.End;
import com.mallardsoft.tuple.Tuple;
import com.mallardsoft.tuple.Variable;

public class TupleComparator<First extends Comparable<First>, Rest> implements Comparator<Tuple<First, Rest>>
{
    private final Comparator<Rest> compareRest;

    TupleComparator(Comparator<Rest> compareRest)
    {
        this.compareRest = compareRest;
    }
    
    /**
     * Begin the reverse construction of an tuple comparison.
     * 
     * @return The penultimate step in a tuple comparison.
     */
    public static <A extends Comparable<A>> TupleComparator<A, End> last()
    {
        return new TupleComparator<A, End>(new EndComparator());
    }
    
    public <T extends Comparable<T>> TupleComparator<T, Tuple<First, Rest>> prepend() 
    {
        return new TupleComparator<T, Tuple<First, Rest>>(this);
    }
    
    public int compare(Tuple<First, Rest> t1,  Tuple<First, Rest> t2)
    {
        Variable<First> v1 = new Variable<First>();
        Rest r1 = t1.extract(v1);
        First f1 = v1.get();

        Variable<First> v2 = new Variable<First>();
        Rest r2 = t2.extract(v2);
        First f2 = v2.get();
        
        int compare = f1.compareTo(f2);
        if (compare == 0)
        {
            return compareRest.compare(r1, r2);
        }
        
        return compare;
    }
}
