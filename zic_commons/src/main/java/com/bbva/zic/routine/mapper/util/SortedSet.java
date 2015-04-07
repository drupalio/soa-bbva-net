/*
 * Orika - simpler, better and faster Java bean mapping
 * 
 * Copyright (C) 2011 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bbva.zic.routine.mapper.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

/**
 * A sorted set implementation based on a Comparator (or type's natural ordering) where the
 * comparison function is allowed to return ordering equivalence (0)
 * which doesn't necessarily imply logical equivalence.
 * <br><br>
 * This allows for the ordering of a set of items where some are less or greater than
 * others, while others are simply not comparable in an ordering sense (in which case, 0 is
 * returned from their comparison).
 * 
 * 
 * @author matt.deboer@gmail.com
 *
 */
public class SortedSet<V> extends SortedCollection<V> implements Set<V> {
    
    /**
     * 
     */
    public SortedSet() {
        super();
    }
    
    /**
     * @param comparator
     */
    public SortedSet(Collection<? extends V> c) {
        super(c);
    }
    
    /**
     * @param comparator
     */
    public SortedSet(Comparator<V> comparator) {
        super(comparator);
    }
    
    /**
     * @param comparator
     */
    public SortedSet(Collection<? extends V> c, Comparator<V> comparator) {
        super(c, comparator);
    }
    
    public boolean add(V value) {
        int i = -1;
        for (V item: sortedList) {
            ++i;
            int comparison = comparator == null ? toComparable(item).compareTo(value) : comparator.compare(item, value);
            if (comparison == 0 && item.equals(value)) {
                return false;
            } else if (comparison > 0) {
                sortedList.add(i, value);
                return true;
            }
        }
        sortedList.addLast(value);
        return true;
    }
}
