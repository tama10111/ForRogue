package forrogue;

import java.util.Comparator;

public class MyComparator implements Comparator<Triplet> {
    @Override
    public int compare(Triplet t1, Triplet t2) {
        if(t1.heuristique > t2.heuristique){
            return 1;
        } else if(t1.heuristique == t2.heuristique){
            return 0;
        } else{
            return -1;
        }
    }
}
