import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomIterator implements Iterator {
    ArrayList<Iterator<Integer>> iterators;
    List<Integer> pool;
    Integer position;
    int min;

    public CustomIterator(ArrayList<Iterator<Integer>> iterators) {
        this.iterators = new ArrayList<>(iterators.stream()
                .filter(x->x.hasNext()).collect(Collectors.toList()));
        this.pool = iterators.stream()
                .map(x->x.next()).collect(Collectors.toList());
    }

    @Override
    public boolean hasNext() {
        return  iterators.stream().anyMatch(x->x.hasNext());
    }

    @Override
    public Integer next() {
            if(position!=null)
            {
                //replace last delivered element with new one
                if(iterators.get(position).hasNext()) {
                    pool.set(position, iterators.get(position).next());
                }
                else {
                    iterators.remove((int)position);
                    pool.remove((int)position);
                }
            }
            min = Collections.min(pool);
            position = pool.indexOf(min);
            return min;
    }
}
