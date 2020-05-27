package exercise;

import java.util.*;

public class TupleIterators {

    /**
     * Implementations must return an iterator that represents the linear merge of the iterators in the provided
     * collection.
     * <p>
     * The contract for this method requires that callers provide iterators that contain only unique keys within their
     * own stream, and whose records are returned in ascending order.  It is not required to gracefully handle API misuse.
     */
    static Iterator<Tuple> merge(Collection<Iterator<Tuple>> iterators) {
        Queue<newIter> minHeap = new PriorityQueue<>();
        List<Tuple> result = new ArrayList<>();
        if (iterators == null || iterators.isEmpty()) {
            return Collections.emptyIterator();
        }

        for (Iterator<Tuple> iter : iterators) {
            if (iter.hasNext())
                minHeap.add(new newIter(iter.next(), iter));
        }

        while (!minHeap.isEmpty()) {
            newIter newiter = minHeap.poll();
            if(!result.isEmpty()){
                Tuple prev = result.get(result.size() - 1);
                Tuple test1 = newiter.getValue();
                if(!test1.equals(prev)){
                    result.add(newiter.getValue());
                }
            }else{
                result.add(newiter.getValue());
            }
            if (newiter.hasNext()) {
                minHeap.add(newiter);
            }
        }
        return result.iterator();
    }



    private static class newIter implements Comparable<newIter> {
        private Tuple value;
        private Iterator<Tuple> iter;

        public newIter(Tuple val, Iterator<Tuple> it) {
            this.value = val;
            this.iter = it;
        }

        public Tuple getValue() {
            return this.value;
        }

        public boolean hasNext() {
            if (iter.hasNext()) {
                value = iter.next();
                return true;
            }
            return false;
        }

        public int compareTo(newIter a) {
            return Tuple.compare(this.value, a.value);
        }
    }
}
