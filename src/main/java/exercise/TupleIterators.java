package exercise;

import java.util.Collection;
import java.util.Iterator;

public class TupleIterators {

    /**
     *  Implementations must return an iterator that represents the linear merge of the iterators in the provided
     *  collection.
     *
     *  The contract for this method requires that callers provide iterators that contain only unique keys within their
     *  own stream, and whose records are returned in ascending order.  It is not required to gracefully handle API misuse.
     */
    static Iterator<Tuple> merge(Collection<Iterator<Tuple>> iterators) {
        // TODO
        return null;
    }

}
