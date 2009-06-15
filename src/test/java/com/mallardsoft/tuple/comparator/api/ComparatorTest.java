package com.mallardsoft.tuple.comparator.api;

import static org.testng.Assert.assertEquals; 

import java.util.SortedSet;
import java.util.TreeSet;

import org.testng.annotations.Test;

import com.mallardsoft.tuple.Pair;
import com.mallardsoft.tuple.Tuple;
import com.mallardsoft.tuple.comparator.Comparators;

public class ComparatorTest
{
    @Test
    public void comparator()
    {
        SortedSet<Pair<Character,Integer>> bingo =  new TreeSet<Pair<Character,Integer>>(Comparators.pair(Character.class, Integer.class));
        
        bingo.add(Tuple.from('B',5));
        bingo.add(Tuple.from('N', 41));
        bingo.add(Tuple.from('I', 23));
        bingo.add(Tuple.from('G',55));
        bingo.add(Tuple.from('O', 69));
        bingo.add(Tuple.from('I', 27));
        bingo.add(Tuple.from('O', 61));

        assertEquals(bingo.toString(), "[(B, 5), (G, 55), (I, 23), (I, 27), (N, 41), (O, 61), (O, 69)]");
    }
}
